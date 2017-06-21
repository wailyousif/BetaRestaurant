package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class SalesItemPrice
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_item_price_seq")
    @SequenceGenerator(name="sales_item_price_seq", sequenceName = "sales_item_price_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private SalesItem salesItem;

    private Date fromDate;
    private Date toDate;
    private double unitPrice;

    @ManyToOne
    private TaxType taxType;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public SalesItemPrice() { }
}
