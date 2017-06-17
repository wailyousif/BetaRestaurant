package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class StockItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_item_type_seq")
    @SequenceGenerator(name="stock_item_type_seq", sequenceName = "stock_item_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String stockItemType;   //Meats, veggies, fruits, pastries, condiments, drinks, …, others
    private String description;

    public StockItemType() { }
}
