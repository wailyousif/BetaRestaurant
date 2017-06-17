package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/5/17.
 */

@Entity
public class Supplier
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name="supplier_seq", sequenceName = "supplier_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String name;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public Supplier() { }
}
