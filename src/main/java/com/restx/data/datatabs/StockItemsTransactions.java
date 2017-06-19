package com.restx.data.datatabs;

import com.restx.data.codestabs.StockTransactionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class StockItemsTransactions
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_items_transactions_seq")
    @SequenceGenerator(name="stock_items_transactions_seq", sequenceName = "stock_items_transactions_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private StockItem stockItem;

    @ManyToOne
    private StockTransactionType transactionType; //Add to Stock, Remove from Stock, Move from Stock to Kitchen, Move from Kitchen to Stock

    @ManyToOne
    private Supplier supplier;

    private double qw;          //Quantity or Weight
    private double unitPrice;
    private double transportationCharges;
    private double totalCost;

    private Date actionTime;

    @ManyToOne
    private AppUser appUser;

    public StockItemsTransactions() { }

    public StockItemsTransactions(RestaurantBranch restaurantBranch, StockItem stockItem, StockTransactionType transactionType, Supplier supplier, double qw, double unitPrice, double transportationCharges, double totalCost, Date actionTime, AppUser appUser) {
        this.restaurantBranch = restaurantBranch;
        this.stockItem = stockItem;
        this.transactionType = transactionType;
        this.supplier = supplier;
        this.qw = qw;
        this.unitPrice = unitPrice;
        this.transportationCharges = transportationCharges;
        this.totalCost = totalCost;
        this.actionTime = actionTime;
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RestaurantBranch getRestaurantBranch() {
        return restaurantBranch;
    }

    public void setRestaurantBranch(RestaurantBranch restaurantBranch) {
        this.restaurantBranch = restaurantBranch;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public StockTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(StockTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public double getQw() {
        return qw;
    }

    public void setQw(double qw) {
        this.qw = qw;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTransportationCharges() {
        return transportationCharges;
    }

    public void setTransportationCharges(double transportationCharges) {
        this.transportationCharges = transportationCharges;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
