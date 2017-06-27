package com.restx.data.datatabs;

import com.restx.data.codestabs.QuantificationUnit;
import com.restx.data.codestabs.StockItemType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/30/17.
 */

@Entity
public class StockItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_item_seq")
    @SequenceGenerator(name="stock_item_seq", sequenceName = "stock_item_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private StockItemType stockItemType;    //Meats, veggies, fruits, pastries, condiments, drinks, …, others

    private String description;
    private double unitPrice;

    @ManyToOne
    private QuantificationUnit quantificationUnit;  //Quantity / Weight (Gram/KG)

    private Boolean enabled;
    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public StockItem() { }

    public StockItem(RestaurantBranch restaurantBranch, String name, StockItemType stockItemType, String description, double unitPrice, QuantificationUnit quantificationUnit, boolean enabled, Date creationTime, AppUser appUser) {
        this.restaurantBranch = restaurantBranch;
        this.name = name;
        this.stockItemType = stockItemType;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantificationUnit = quantificationUnit;
        this.enabled = enabled;
        this.creationTime = creationTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StockItemType getStockItemType() {
        return stockItemType;
    }

    public void setStockItemType(StockItemType stockItemType) {
        this.stockItemType = stockItemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public QuantificationUnit getQuantificationUnit() {
        return quantificationUnit;
    }

    public void setQuantificationUnit(QuantificationUnit quantificationUnit) {
        this.quantificationUnit = quantificationUnit;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
