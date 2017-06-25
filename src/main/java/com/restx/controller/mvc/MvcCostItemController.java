package com.restx.controller.mvc;

import com.restx.data.codestabs.CostCategory;
import com.restx.data.codestabs.Recurrence;
import com.restx.data.datatabs.*;
import com.restx.data.repo.CostItemCostRepo;
import com.restx.data.repo.CostItemHistRepo;
import com.restx.data.repo.CostItemRepo;
import com.restx.dto.ResponseObject;
import com.restx.services.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/24/17.
 */

@Controller
@RequestMapping(path = "/mvc/method/costitem")
public class MvcCostItemController
{
    private final static Logger logger = Logger.getLogger(MvcCostItemController.class);

    @Autowired
    private CostItemRepo costItemRepo;

    @Autowired
    private CostItemCostRepo costItemCostRepo;

    @Autowired
    private CostItemHistRepo costItemHistRepo;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> add(
            HttpServletRequest request,
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
            AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");
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
            responseObject.setResponseString("Cost Item created successfully.");
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



    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> update(
            HttpServletRequest request,
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
            CostItem costItem = costItemRepo.findOne(costItemId);
            CostItemHist costItemHist = new CostItemHist();
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

            CostCategory costCategory = new CostCategory();
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

            AppUser actionBy = (AppUser)request.getSession().getAttribute("appUser");

            costItemHist.setActionType("U");
            costItemHist.setActionTime(new Date());
            costItemHist.setActionBy(actionBy);

            costItemHistRepo.save(costItemHist);
            costItemRepo.save(costItem);

            responseObject.setSuccess(true);
            responseObject.setResponseCode(0);
            responseObject.setResponseString("Cost Item updated successfully.");
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
