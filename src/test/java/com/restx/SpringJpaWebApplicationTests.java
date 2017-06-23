package com.restx;

import com.restx.data.codestabs.StockTransactionType;
import com.restx.data.datatabs.Address;
import com.restx.data.datatabs.Employee;
import com.restx.data.datatabs.RestaurantBranch;
import com.restx.data.datatabs.TestCls;
import com.restx.data.repo.RestaurantBranchRepo;
import com.restx.data.repo.TestClsRepo;
import com.restx.dto.ResponseObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
	private RestaurantBranchRepo restaurantBranchRepo;

	@Test
	public void walkThroughTest()
	{
		StockTransactionType stockTransactionType = new StockTransactionType();
		stockTransactionType.setId(1);
		TestCls testCls = new TestCls(stockTransactionType, "Test One");
		testClsRepo.save(testCls);

		int ret = updateBranchInfo(-1L, "", "Mashtal Branch",
				"107", "", "Mashtal St.", "KRT", "GKRT",
				"Sudan", "107", 80.0, 20.0, -1L);

		System.out.println("ret=" + ret);
	}

	public int updateBranchInfo(
			Long branchId,
			String arabicName,
			String englishName,
			String addressLine1,
			String addressLine2,
			String street,
			String city,
			String state,
			String country,
			String zipCode,
			Double lat,
			Double lng,
			Long branchManagerEmployeeId
	)
	{
		ResponseObject responseObject = new ResponseObject(false, -10,
				"Failed to update branch information. Contact system administrator.");
		ResponseEntity<ResponseObject> responseEntity;

		try
		{
			RestaurantBranch restaurantBranch = restaurantBranchRepo.findOne(branchId);
			Address branchAddress = restaurantBranch.getAddress();

			branchAddress.setAddressLine1(addressLine1);
			branchAddress.setAddressLine2(addressLine2);
			branchAddress.setStreet(street);
			branchAddress.setCity(city);
			branchAddress.setState(state);
			branchAddress.setCountry(country);
			branchAddress.setZipCode(zipCode);
			branchAddress.setLat(lat);
			branchAddress.setLng(lng);

			Employee branchManager = new Employee();
			branchManager.setId(branchManagerEmployeeId);

			restaurantBranch.setAddress(branchAddress);
			restaurantBranch.setArabicName(arabicName);
			restaurantBranch.setEnglishName(englishName);
			restaurantBranch.setBranchManager(branchManager);

			restaurantBranchRepo.save(restaurantBranch);

			responseObject.setSuccess(true);
			responseObject.setResponseCode(0);
			responseObject.setResponseString("Branch information updated successfully.");
			responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
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

		return 0;
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
