package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class RegularOrderDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regular_order_details_seq")
    @SequenceGenerator(name="regular_order_details_seq", sequenceName = "regular_order_details_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private RegularOrder regularOrder;

    @ManyToOne
    private SalesItem salesItem;

    private int quantity;
    private double unitPrice;
    private double totalPrice;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public RegularOrderDetails() { }
}
