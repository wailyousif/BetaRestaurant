package com.restx.controller.mvc;

import com.restx.dto.ResponseObject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wailm.yousif on 6/19/17.
 */

@Controller
@RequestMapping(path = "/mvc/method/stock")
public class MvcStockController
{
    private final static Logger logger = Logger.getLogger(MvcStockController.class);

    @RequestMapping(path = "/itemadd", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> itemAdd(
            HttpServletRequest request,
            String stockItemName,
            String transactionType,
            String supplierName,
            Double qw,
            Double unitPrice,
            Double transportationCharges,
            Double totalCost
    )
    {
        ///logger.info("User (" + username + "): log-in attempt.");

        ResponseObject responseObject = new ResponseObject(false, 10, "Incorrect Credentials");
        ResponseEntity<ResponseObject> responseEntity;

        try
        {

            if (false)
            {
                //logger.info("User (" + username + "): is disabled.");
                responseObject.setResponseCode(20);
                responseObject.setResponseString("User is Disabled!");
            }
            else
            {
                responseObject.setSuccess(true);
                responseObject.setResponseCode(0);
                //logger.info("User (" + username + "): logged in successfully.");
                //responseObject.setResponseString(securePath + defaultPage);
            }
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("Handled Exception", ex);
            responseObject.setSuccess(false);
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            //DbContextHolder.clearDbType();
        }

        return responseEntity;
    }

}
