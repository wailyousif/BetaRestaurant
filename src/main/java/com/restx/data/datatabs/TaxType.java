package com.restx.data.datatabs;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class TaxType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_type_seq")
    @SequenceGenerator(name="tax_type_seq", sequenceName = "tax_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String taxType;
    private String description;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    public TaxType() { }
}
