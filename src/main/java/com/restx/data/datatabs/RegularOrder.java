package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class RegularOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regular_order_seq")
    @SequenceGenerator(name="regular_order_seq", sequenceName = "regular_order_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private Employee waiter;

    @ManyToOne
    private Customer customer;

    private double subTotal;

    @ManyToOne
    private TaxType taxType;
    private double taxes;

    private double serviceFees;
    private double invoiceTotal;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    private int status;     //0: pending payment, 1: paid, -1: canceled

    public RegularOrder() { }
}
