package com.restx.data.datatabs;

import com.restx.data.codestabs.CostCategory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class CostItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_item_seq")
    @SequenceGenerator(name="cost_item_seq", sequenceName = "cost_item_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String name;
    private String description;

    /*
        @JoinColumns({
            @JoinColumn(
                    name = "cost_category",
                    referencedColumnName = "cost_category"),
            @JoinColumn(
                    name = "language_id",
                    referencedColumnName = "language_id")
    })
     */
    @ManyToOne
    private CostCategory costCategory;  //Governmental, Employees Benefits, Rental, Utilities, Others

    private boolean enabled;
    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public CostItem() { }

    public CostItem(RestaurantBranch restaurantBranch, String name, String description, CostCategory costCategory, boolean enabled, Date creationTime, AppUser appUser) {
        this.restaurantBranch = restaurantBranch;
        this.name = name;
        this.description = description;
        this.costCategory = costCategory;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CostCategory getCostCategory() {
        return costCategory;
    }

    public void setCostCategory(CostCategory costCategory) {
        this.costCategory = costCategory;
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
