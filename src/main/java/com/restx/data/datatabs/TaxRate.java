package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class TaxRate
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_rate_seq")
    @SequenceGenerator(name="tax_rate_seq", sequenceName = "tax_rate_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    @ManyToOne
    private TaxType taxType;

    private Date fromDate;
    private Date toDate;
    private double taxRate;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public TaxRate() { }
}
