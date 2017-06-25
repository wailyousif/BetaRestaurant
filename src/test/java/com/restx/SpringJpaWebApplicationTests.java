package com.restx;

import com.restx.data.codestabs.CostCategory;
import com.restx.data.codestabs.Recurrence;
import com.restx.data.codestabs.StockTransactionType;
import com.restx.data.datatabs.*;
import com.restx.data.repo.*;
import com.restx.dto.ResponseObject;
import com.restx.services.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	public void walkThroughTest()
	{
		StockTransactionType stockTransactionType = new StockTransactionType();
		stockTransactionType.setId(1);
		TestCls testCls = new TestCls(stockTransactionType, "Test One");
		testClsRepo.save(testCls);

		/*
		int ret = updateBranchInfo(-1L, "فرع المشتل", "Mashtal Branch",
				"107", "", "Mashtal St.", "KRT", "GKRT",
				"Sudan", "107", null, null, -1L);
		System.out.println("ret=" + ret);
				*/

		int ret = add("غاز", "غاز الطبخ", 4L, true, "01/JUL/2017", "",
				3L, 500.0);
		System.out.println("add=" + ret);

		ret = update(1L, "غاز", "غاز الطبخ الجاهز", 4L, true);
		System.out.println("update=" + ret);
	}


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

			Recurrence recurrence = new Recurrence();
			recurrence.setId(recurrenceId);

			Date startDate = Utils.arabianDf.parse(fromDate);
			Date endDate = null;
			if (!toDate.equals(Utils.emptyString))
				endDate = Utils.arabianDf.parse(toDate);

			CostItemCost costItemCost = new CostItemCost(restaurantBranch, costItem, startDate,
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
			CostCategory costCategory = new CostCategory();

			CostItemHist costItemHist = new CostItemHist();
			CostItem costItem = costItemRepo.findOne(costItemId);
			costItemHist.setCostItem(costItem);

			if (!name.equals(costItem.getName()))
			{
				costItemHist.setName(costItem.getName());
				costItem.setName(name);
			}

			if (!description.equals(costItem.getDescription()))
			{
				costItemHist.setDescription(costItem.getDescription());
				costItem.setDescription(description);
			}

			if (costCategoryId != costItem.getCostCategory().getId())
			{
				costItemHist.setCostCategory(costItem.getCostCategory());
				costCategory.setId(costCategoryId);
				costItem.setCostCategory(costCategory);
			}

			if (enabled != costItem.isEnabled())
			{
				costItemHist.setEnabled(costItem.isEnabled());
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
