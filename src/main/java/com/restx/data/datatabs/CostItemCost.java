package com.restx.data.datatabs;

import com.restx.data.codestabs.Recurrence;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/21/17.
 */

@Entity
public class CostItemCost
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_item_cost_seq")
    @SequenceGenerator(name="cost_item_cost_seq", sequenceName = "cost_item_cost_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CostItem costItem;

    private Date fromDate;
    private Date toDate;

    @ManyToOne
    private Recurrence recurrence;  //ad-hoc, daily, weekly, monthly, quarterly, bi-annual, annual

    private double cost;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public CostItemCost() { }

    public CostItemCost(RestaurantBranch restaurantBranch, CostItem costItem, Date fromDate, Date toDate, Recurrence recurrence, double cost, Date creationTime, AppUser appUser) {
        this.restaurantBranch = restaurantBranch;
        this.costItem = costItem;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.recurrence = recurrence;
        this.cost = cost;
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

    public CostItem getCostItem() {
        return costItem;
    }

    public void setCostItem(CostItem costItem) {
        this.costItem = costItem;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
