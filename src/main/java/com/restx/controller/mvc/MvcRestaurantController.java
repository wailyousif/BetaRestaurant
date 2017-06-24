package com.restx.controller.mvc;

import com.restx.data.datatabs.*;
import com.restx.data.repo.RestaurantBranchRepo;
import com.restx.data.repo.RestaurantRepo;
import com.restx.dto.ResponseObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by wailm.yousif on 6/23/17.
 */

@Controller
@RequestMapping(path = "/mvc/method/restaurant")
public class MvcRestaurantController 
{
    private final static Logger logger = Logger.getLogger(MvcRestaurantController.class);

    @Value("${upload.location}")
    private String uploadLocation;

    @Value("${upload.max.logo.kbs}")
    private Long maxLogoKBs;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private RestaurantBranchRepo restaurantBranchRepo;

    @RequestMapping(path = "/updateinfo", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> updateInfo(
            HttpServletRequest request,
            String arabicName,
            String englishName,
            Boolean newLogoFile,
            MultipartFile logoFile,
            String addressLine1,
            String addressLine2,
            String street,
            String city,
            String state,
            String country,
            String zipCode,
            Double lat,
            Double lng,
            String ownerName,
            String ownerPhone,
            String ownerEmail,
            String ownerAddressLine1,
            String ownerAddressLine2,
            String ownerStreet,
            String ownerCity,
            String ownerState,
            String ownerCountry,
            String ownerZipCode,
            Double ownerLat,
            Double ownerLng
    )
    {
        ResponseObject responseObject = new ResponseObject(false, -10,
                "Failed to update restaurant information. Contact system administrator.");
        ResponseEntity<ResponseObject> responseEntity;

        try
        {
            AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");
            String logoFileName = "logo.pic";

            if (newLogoFile)
            {
                if (logoFile == null)
                {
                    responseObject.setResponseCode(-10);
                    responseObject.setResponseString("You ticked the 'New Logo' checkbox, but you didn't upload a logo file.");
                    responseEntity = new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
                    return responseEntity;
                }
                if (logoFile.getSize() > maxLogoKBs*1024)
                {
                    responseObject.setResponseCode(-20);
                    responseObject.setResponseString("Logo file size must be less than 256KBs.");
                    responseEntity = new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
                    return responseEntity;
                }
            }

            Long restaurantId = appUser.getRestaurantBranch().getRestaurant().getId();
            Restaurant restaurant = restaurantRepo.findOne(restaurantId);

            Address hqAddress = restaurant.getHqAddress();
            RestaurantOwner owner = restaurant.getOwner();
            ContactInfo ownerContact = owner.getContactInfo();
            Address ownerAddress = ownerContact.getAddress();

            ownerAddress.setAddressLine1(ownerAddressLine1);
            ownerAddress.setAddressLine2(ownerAddressLine2);
            ownerAddress.setStreet(ownerStreet);
            ownerAddress.setCity(ownerCity);
            ownerAddress.setState(ownerState);
            ownerAddress.setCountry(ownerCountry);
            ownerAddress.setZipCode(ownerZipCode);
            if (ownerLat != null)
                ownerAddress.setLat(ownerLat);
            if (ownerLng != null)
                ownerAddress.setLng(ownerLng);
            ownerContact.setAddress(ownerAddress);

            ownerContact.setPhone(ownerPhone);
            ownerContact.setEmail(ownerEmail);

            owner.setContactInfo(ownerContact);
            owner.setName(ownerName);
            restaurant.setOwner(owner);

            hqAddress.setAddressLine1(addressLine1);
            hqAddress.setAddressLine2(addressLine2);
            hqAddress.setStreet(street);
            hqAddress.setCity(city);
            hqAddress.setState(state);
            hqAddress.setCountry(country);
            hqAddress.setZipCode(zipCode);
            if (lat != null)
                hqAddress.setLat(lat);
            if (lng != null)
                hqAddress.setLng(lng);
            restaurant.setHqAddress(hqAddress);

            restaurant.setArabicName(arabicName);
            restaurant.setEnglishName(englishName);

            restaurantRepo.save(restaurant);

            if (newLogoFile)
            {
                String restaurantUploadLocation = uploadLocation + "r" + String.valueOf(restaurantId) + "/";
                Path path = Paths.get(restaurantUploadLocation);
                if (!Files.exists(path))
                {
                    Files.createDirectories(path);
                    logger.warn("Path " + restaurantUploadLocation + " did not exist. It has been created.");
                }
                Files.copy(logoFile.getInputStream(),
                        Paths.get(restaurantUploadLocation + logoFileName));
            }

            responseObject.setSuccess(true);
            responseObject.setResponseCode(0);
            responseObject.setResponseString("Restaurant information updated successfully.");
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("Handled Exception", ex);
            responseObject.setSuccess(false);
            responseObject.setResponseCode(-1000);
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally
        {

        }

        return responseEntity;
    }



    @RequestMapping(path = "/updatebranchinfo", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> updateBranchInfo(
            HttpServletRequest request,
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
            if (lat != null)
                branchAddress.setLat(lat);
            if (lng != null)
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
            logger.error("Handled Exception", ex);
            responseObject.setSuccess(false);
            responseObject.setResponseCode(-1000);
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally
        {

        }

        return responseEntity;

    }
}
