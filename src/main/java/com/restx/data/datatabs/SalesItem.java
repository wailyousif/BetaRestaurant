package com.restx.data.datatabs;

import com.restx.data.codestabs.SalesItemType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class SalesItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_item_seq")
    @SequenceGenerator(name="sales_item_seq", sequenceName = "sales_item_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String name;

    @ManyToOne
    private SalesItemType salesItemType;    //Sandwich, Appetizer, Dish, Desert, Drink, etc.

    private String description;
    private boolean enabled;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public SalesItem() { }

    public SalesItem(RestaurantBranch restaurantBranch, String name, SalesItemType salesItemType, String description, boolean enabled, Date creationTime, AppUser appUser) {
        this.restaurantBranch = restaurantBranch;
        this.name = name;
        this.salesItemType = salesItemType;
        this.description = description;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
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
}
