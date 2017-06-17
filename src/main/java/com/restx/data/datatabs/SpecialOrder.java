package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/6/17.
 */

@Entity
public class SpecialOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "special_order_seq")
    @SequenceGenerator(name="special_order_seq", sequenceName = "special_order_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private SpecialOrderType specialOrderType;  //Open Buffet, Junket or Wedding

    private int quantity;   //No. of people or No. of Dishes
    private double unitPrice;   //cost per one individual or one dish
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

    public SpecialOrder() { }
}
