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

    @ManyToOne
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
}
