package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/1/17.
 */

@Entity
public class StockItemStatus
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_item_status_seq")
    @SequenceGenerator(name="stock_item_status_seq", sequenceName = "stock_item_status_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @OneToOne
    private StockItem stockItem;

    private double qwInStock;       //qw means quantity or weight
    private double qwInKitchen;

    private String lastTransactionType;
    private Date lastTransactionTime;
    private double lastTransactionQw;

    @ManyToOne
    private AppUser lastTransactionUser;

    public StockItemStatus() { }
}
