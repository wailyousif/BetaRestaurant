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

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public StockItem() { }
}
