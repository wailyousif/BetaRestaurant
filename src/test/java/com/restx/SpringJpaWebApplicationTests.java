package com.restx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.restx.data.codestabs.CostCategory;
import com.restx.data.codestabs.Recurrence;
import com.restx.data.codestabs.StockTransactionType;
import com.restx.data.datatabs.*;
import com.restx.data.repo.*;
import com.restx.dto.ResponseObject;
import com.restx.services.Utils;
import com.sun.corba.se.impl.logging.UtilSystemException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaWebApplicationTests {

	@Test
	public void contextLoads() { }

	@Autowired
	private TestClsRepo testClsRepo;

	@Autowired
	private CostItemRepo costItemRepo;

	@Autowired
	private CostItemCostRepo costItemCostRepo;

	@Autowired
	private CostItemHistRepo costItemHistRepo;


	@Autowired
	private AppUserRepo appUserRepo;

	@Test
	public void walkThroughTest() throws JsonProcessingException {
		StockTransactionType stockTransactionType = new StockTransactionType();
		stockTransactionType.setId(1);
		TestCls testCls = new TestCls(stockTransactionType, "Test One");
		testClsRepo.save(testCls);

		int ret = add("غاز", "غاز الطبخ", 4L, true, "01/JUN/2017", "29/JUN/2017",
				3L, 500.0);
		System.out.println("add=" + ret);

		ret = update(1L, "غاز", "غاز الطبخ الجاهز", 4L, true);
		System.out.println("update=" + ret);

		ret = updateCostDetails(1L, "30/JUN/2017", "14/JUL/2017", 4L, 530.0);
		System.out.println("updateDetails1=" + ret);

		ret = updateCostDetails(1L, "15/AUG/2017", "01/SEP/2017", 4L, 540.0);
		System.out.println("updateDetails2=" + ret);

		ResponseObject respObj = getHeaders();
		System.out.println("getHeaders=" + respObj.getResponseString());


		List<Object[]> listOfObjectsArray = costItemRepo.findAllWithCurrentCost();
		String[] keys = {"id", "name", "description", "creationTime", "enabled", "langCode", "displayName", "cost"};
		String jsonArr = "[";
		//for (Object[] objectsArray: listOfObjectsArray)
		for (int k=0; k < listOfObjectsArray.size(); k++)
		{
			Object[] objectsArray = listOfObjectsArray.get(k);
			String jsonObj = "{";
			for (int i=0; i < objectsArray.length; i++)
			{
				jsonObj += "\"" + keys[i] + "\":\"" + objectsArray[i] + "\"";
				if (i < objectsArray.length-1)
					jsonObj += ", ";
			}
			jsonObj += "}";
			if (k < listOfObjectsArray.size()-1)
				jsonObj += ", ";
			jsonArr += jsonObj;
			/*
			String ss = Utils.emptyString;
			for (Object obj: objectsArray)
			{
				System.out.println(obj);
				ss = ss + String.valueOf(obj) + ", ";
			}
			System.out.println("ss=" + ss);
			*/
		}
		jsonArr += "]";
		//String json = (new Gson()).toJson(listOfObjectsArray);
		//System.out.println("json=" + json);
		System.out.println("jsonArr=" + jsonArr);


		List<CostItemCost> costItemCosts = costItemCostRepo.findByCostItemOrdered(1L);
		ObjectMapper mapper = new ObjectMapper();
		String detJson = mapper.writeValueAsString(costItemCosts);
		System.out.println("detJson=" + detJson);
	}


	public ResponseObject getHeaders()
	{
		ResponseObject responseObject = new ResponseObject(false, -10,
				"Could not fetch Cost Items. Contact system administrator.");
		ResponseEntity<ResponseObject> responseEntity;

		try
		{
			List<CostItem> costItems = costItemRepo.findAllSortedById();

			responseObject.setSuccess(true);
			responseObject.setResponseCode(0);
			responseObject.setResponseString((new Gson()).toJson(costItems));
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
		}
		catch (Exception ex)
		{
			responseObject.setSuccess(false);
			responseObject.setResponseCode(-1000);
			responseObject.setResponseString(ex.getMessage());
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		finally
		{

		}
		return responseObject;
	}


	@Transactional
	public int add(
			String name,
			String description,
			Long costCategoryId,
			Boolean enabled,
			String fromDate,
			String toDate,
			Long recurrenceId,
			Double cost
	)
	{
		ResponseObject responseObject = new ResponseObject(false, -10,
				"Failed to add the Cost Item. Contact system administrator.");
		ResponseEntity<ResponseObject> responseEntity;

		try
		{
			//AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");
			AppUser appUser = appUserRepo.findOne(-1L);
			RestaurantBranch restaurantBranch = new RestaurantBranch();
			restaurantBranch.setId(appUser.getRestaurantBranch().getId());

			CostCategory costCategory = new CostCategory();
			costCategory.setId(costCategoryId);

			CostItem costItem = new CostItem(restaurantBranch, name, description, costCategory,
					enabled, new Date(), appUser);

			costItemRepo.save(costItem);

			CostItemHist costItemHist = new CostItemHist(costItem, name, description, costCategory,
					enabled, "I", new Date(), appUser);

			costItemHistRepo.save(costItemHist);


			Recurrence recurrence = new Recurrence();
			recurrence.setId(recurrenceId);

			Date startDate = Utils.arabianDf.parse(fromDate);
			Date endDate = null;
			if (!toDate.equals(Utils.emptyString))
				endDate = Utils.arabianDf.parse(toDate);

			CostItemCost costItemCost = new CostItemCost(costItem, startDate,
					endDate, recurrence, cost, new Date(), appUser);

			costItemCostRepo.save(costItemCost);

			responseObject.setSuccess(true);
			responseObject.setResponseCode(0);
			responseObject.setResponseString("Branch information updated successfully.");
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
			return 0;
		}
		catch (Exception ex)
		{
			responseObject.setSuccess(false);
			responseObject.setResponseCode(-1000);
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
			return -1000;
		}
		finally
		{

		}
	}


	@Transactional
	public int update(
			Long costItemId,
			String name,
			String description,
			Long costCategoryId,
			Boolean enabled
	)
	{
		ResponseObject responseObject = new ResponseObject(false, -10,
				"Failed to update the Cost Item. Contact system administrator.");
		ResponseEntity<ResponseObject> responseEntity;

		try
		{

			CostItemHist costItemHist = new CostItemHist();
			CostItem costItem = costItemRepo.findOne(costItemId);
			costItemHist.setCostItem(costItem);

			if (!name.equals(costItem.getName()))
			{
				costItemHist.setName(name);
				costItem.setName(name);
			}

			if (!description.equals(costItem.getDescription()))
			{
				costItemHist.setDescription(description);
				costItem.setDescription(description);
			}

			CostCategory costCategory = new CostCategory();
			if (costCategoryId != costItem.getCostCategory().getId())
			{
				costCategory.setId(costCategoryId);
				costItemHist.setCostCategory(costCategory);
				costItem.setCostCategory(costCategory);
			}

			if (enabled != costItem.getEnabled())
			{
				costItemHist.setEnabled(enabled);
				costItem.setEnabled(enabled);
			}

			String actionType = "U";
			Date actionTime = new Date();
			//AppUser actionBy = (AppUser)request.getSession().getAttribute("appUser");
			AppUser actionBy = appUserRepo.findOne(-1L);

			costItemHist.setActionType(actionType);
			costItemHist.setActionTime(actionTime);
			costItemHist.setActionBy(actionBy);

			costItemHistRepo.save(costItemHist);
			costItemRepo.save(costItem);

			responseObject.setSuccess(true);
			responseObject.setResponseCode(0);
			responseObject.setResponseString("Cost Item updated successfully.");
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
			return 0;
		}
		catch (Exception ex)
		{
			responseObject.setSuccess(false);
			responseObject.setResponseCode(-1000);
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
			return -999;
		}
		finally
		{

		}
	}


	@Transactional
	public int updateCostDetails(
			Long costItemId,
			String newFromDate,
			String newToDate,
			Long newRecurrenceId,
			Double newCost
	)
	{
		ResponseObject responseObject = new ResponseObject(false, -10,
				"Failed to update the Cost Details. Contact system administrator.");
		ResponseEntity<ResponseObject> responseEntity;

		try
		{
			CostItem costItem = new CostItem();
			costItem.setId(costItemId);

			Date newStartDate = Utils.arabianDf.parse(newFromDate);
			Date newEndDate = null;
			Date nonNullEndDate;

			if (!newToDate.equals(Utils.emptyString))
			{
				newEndDate = Utils.arabianDf.parse(newToDate);
				nonNullEndDate = newEndDate;
			}
			else
				nonNullEndDate = Utils.arabianDf.parse("31/DEC/9999");

			//Integer conflictCount = costItemCostRepo.findEndDatesAfter(costItemId, newStartDate);
			Integer conflictCount = costItemCostRepo.findConflictingDates(costItemId, newStartDate, nonNullEndDate);
			if (conflictCount > 0)
			{
				responseObject.setSuccess(false);
				responseObject.setResponseCode(-20);
				responseObject.setResponseString("The end-date of one (or more) item(s) conflicts with your selected start-date");
				responseEntity = new ResponseEntity<>(responseObject, HttpStatus.CONFLICT);
				return  -501;
			}

			CostItemCost currCostItemCost = costItemCostRepo.findOpenedOne(costItemId);
			if (currCostItemCost != null)
			{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(newStartDate);
				calendar.add(Calendar.DATE, -1);
				Date currEndDate = calendar.getTime();
				currCostItemCost.setEndDate(currEndDate);
				costItemCostRepo.save(currCostItemCost);
			}

			//AppUser createdBy = (AppUser)request.getSession().getAttribute("appUser");
			AppUser createdBy = appUserRepo.findOne(-1L);

			Recurrence newRecurrence = new Recurrence();
			newRecurrence.setId(newRecurrenceId);

			CostItemCost costItemCost = new CostItemCost(costItem, newStartDate,
					newEndDate, newRecurrence, newCost, new Date(), createdBy);

			costItemCostRepo.save(costItemCost);

			responseObject.setSuccess(true);
			responseObject.setResponseCode(0);
			responseObject.setResponseString("Cost details has been updated successfully.");
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
			return 0;
		}
		catch (Exception ex)
		{
			responseObject.setSuccess(false);
			responseObject.setResponseCode(-1000);
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
			return -998;
		}
		finally
		{

		}
	}



	private ResponseEntity<String> doHttp(String url, MultiValueMap<String, Object> map, MediaType mediaType,
										  HashMap<String, String> customHeaders)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		if (customHeaders != null)
		{
			Iterator it = customHeaders.entrySet().iterator();
			while (it.hasNext())
			{
				Map.Entry pair = (Map.Entry)it.next();
				headers.add(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

		//ResponseObject responseObject = (new RestTemplate()).postForEntity(url, requestEntity, ResponseObject.class).getBody();
		//ResponseObject responseObject = (new RestTemplate()).exchange(url, HttpMethod.POST, requestEntity, ResponseObject.class).getBody();
		ResponseEntity<String> responseEntity =
				(new RestTemplate()).exchange(url, HttpMethod.POST, requestEntity, ResponseEntity.class).getBody();
		return responseEntity;
	}
}
