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

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public SalesItem() { }
}
