package com.restx.data.datatabs;

import com.restx.data.codestabs.SalesItemType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class SalesItemHist
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_item_hist_seq")
    @SequenceGenerator(name="sales_item_hist_seq", sequenceName = "sales_item_hist_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String name;

    @ManyToOne
    private SalesItemType salesItemType;    //Sandwich, Appetizer, Dish, Desert, Drink, etc.

    private String description;
    private Boolean enabled;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    private String actionType;

    @ManyToOne
    private AppUser actionBy;

    public SalesItemHist() { }

    public SalesItemHist(RestaurantBranch restaurantBranch, String name, SalesItemType salesItemType, String description, boolean enabled, Date creationTime, AppUser appUser, String actionType, AppUser actionBy) {
        this.restaurantBranch = restaurantBranch;
        this.name = name;
        this.salesItemType = salesItemType;
        this.description = description;
        this.enabled = enabled;
        this.creationTime = creationTime;
        this.appUser = appUser;
        this.actionType = actionType;
        this.actionBy = actionBy;
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

    public SalesItemType getSalesItemType() {
        return salesItemType;
    }

    public void setSalesItemType(SalesItemType salesItemType) {
        this.salesItemType = salesItemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public AppUser getActionBy() {
        return actionBy;
    }

    public void setActionBy(AppUser actionBy) {
        this.actionBy = actionBy;
    }
}
