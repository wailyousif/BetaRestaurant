package com.restx.controller.mvc;

import com.restx.data.codestabs.StockTransactionType;
import com.restx.data.datatabs.AppUser;
import com.restx.data.datatabs.StockItem;
import com.restx.data.datatabs.StockItemsTransactions;
import com.restx.data.datatabs.Supplier;
import com.restx.data.repo.StockItemsTransactionsRepo;
import com.restx.dto.ResponseObject;
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
 * Created by wailm.yousif on 6/19/17.
 */

@Controller
@RequestMapping(path = "/mvc/method/stock")
public class MvcStockController
{
    private final static Logger logger = Logger.getLogger(MvcStockController.class);

    @Autowired
    private StockItemsTransactionsRepo stockItemsTransactionsRepo;

    @RequestMapping(path = "/itemadd", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> itemAdd(
            HttpServletRequest request,
            Long stockItemId,
            Long transactionTypeId,
            Long supplierId,
            Double qw,
            Double unitPrice,
            Double transportationCharges,
            Double totalCost
    )
    {
        ///logger.info("User (" + username + "): log-in attempt.");

        ResponseObject responseObject = new ResponseObject(false, 10,
                "Failed to add stock item");
        ResponseEntity<ResponseObject> responseEntity;

        try
        {
            AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");

            /*
            StockItem stockItem = stockItemRepo.findByName(stockItemName);
            StockTransactionType stockTransactionType = stockTransactionTypeRepo.findByCode(transactionType);
            Supplier supplier = supplierRepo.findByName(supplierName);
            */

            StockItem stockItem = new StockItem();
            stockItem.setId(stockItemId);

            StockTransactionType stockTransactionType = new StockTransactionType();
            stockTransactionType.setId(transactionTypeId);

            Supplier supplier = new Supplier();
            supplier.setId(supplierId);

            StockItemsTransactions stockItemsTransactions =
                    new StockItemsTransactions(appUser.getRestaurantBranch(), stockItem,
                            stockTransactionType, supplier, qw, unitPrice,
                            transportationCharges, totalCost,
                            new Date(), appUser);

            stockItemsTransactionsRepo.save(stockItemsTransactions);
            responseObject.setSuccess(true);
            responseObject.setResponseCode(0);
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
