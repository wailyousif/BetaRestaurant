package com.restx.data.datatabs;

import com.restx.data.codestabs.QuantificationMethod;

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

    private String name;

    @ManyToOne
    private StockItemType stockItemType;    //Meats, veggies, fruits, pastries, condiments, drinks, …, others

    private String description;
    private double unitPrice;

    @ManyToOne
    private QuantificationMethod quantificationMethod;  //Quantity / Weight (Gram/KG)

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public StockItem() { }
}
