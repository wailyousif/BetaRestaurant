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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RestaurantOwner owner;

    //private String logoFile;  //logo.pic for all restaurants. Each restaurant has its own path.

    public Restaurant() { }

    public Restaurant(String arabicName, String englishName, Address hqAddress, RestaurantOwner owner) {
        this.arabicName = arabicName;
        this.englishName = englishName;
        this.hqAddress = hqAddress;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Address getHqAddress() {
        return hqAddress;
    }

    public void setHqAddress(Address hqAddress) {
        this.hqAddress = hqAddress;
    }

    public RestaurantOwner getOwner() {
        return owner;
    }

    public void setOwner(RestaurantOwner owner) {
        this.owner = owner;
    }
}
