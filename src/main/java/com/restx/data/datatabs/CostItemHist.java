package com.restx.data.datatabs;

import com.restx.data.codestabs.CostCategory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class CostItemHist
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_item_hist_seq")
    @SequenceGenerator(name="cost_item_hist_seq", sequenceName = "cost_item_hist_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private CostItem costItem;

    private String name;
    private String description;

    @ManyToOne
    private CostCategory costCategory;  //Governmental, Employees Benefits, Rental, Utilities, Others

    private boolean enabled;

    private String actionType;
    private Date actionTime;

    @ManyToOne
    private AppUser actionBy;

    public CostItemHist() { }

    public CostItemHist(CostItem costItem, String name, String description, CostCategory costCategory, boolean enabled, String actionType, Date actionTime, AppUser actionBy) {
        this.costItem = costItem;
        this.name = name;
        this.description = description;
        this.costCategory = costCategory;
        this.enabled = enabled;
        this.actionType = actionType;
        this.actionTime = actionTime;
        this.actionBy = actionBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public CostItem getCostItem() {
        return costItem;
    }

    public void setCostItem(CostItem costItem) {
        this.costItem = costItem;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }
}
