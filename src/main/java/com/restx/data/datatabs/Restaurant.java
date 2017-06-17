package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/5/17.
 */

@Entity
public class Restaurant
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    @SequenceGenerator(name="restaurant_seq", sequenceName = "restaurant_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String arabicName;
    private String englishName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address hqAddress;

    @ManyToOne
    private RestaurantOwner owner;

    private String logoFile;

    public Restaurant() { }
}
