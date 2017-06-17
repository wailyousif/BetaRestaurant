package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class StockItemsTransactions
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_items_transactions_seq")
    @SequenceGenerator(name="stock_items_transactions_seq", sequenceName = "stock_items_transactions_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private StockItem stockItem;

    private String transactionType; //Add to Stock, Remove from Stock, Move from Stock to Kitchen, Move from Kitchen to Stock

    @ManyToOne
    private Supplier supplier;

    private double qw;          //Quantity or Weight
    private double unitPrice;
    private double transportationCharges;
    private double totalCost;

    private Date actionTime;

    @ManyToOne
    private AppUser appUser;

    public StockItemsTransactions() { }
}
