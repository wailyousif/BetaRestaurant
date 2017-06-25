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

    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToOne
    private CostItem costItem;

    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Recurrence recurrence;  //ad-hoc, daily, weekly, monthly, quarterly, bi-annual, annual

    private double cost;

    private Date creationTime;

    @ManyToOne
    private AppUser createdBy;

    public CostItemCost() { }

    public CostItemCost(CostItem costItem, Date startDate, Date endDate, Recurrence recurrence, double cost, Date creationTime, AppUser createdBy) {
        this.costItem = costItem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.recurrence = recurrence;
        this.cost = cost;
        this.creationTime = creationTime;
        this.createdBy = createdBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CostItem getCostItem() {
        return costItem;
    }

    public void setCostItem(CostItem costItem) {
        this.costItem = costItem;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public AppUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }
}
