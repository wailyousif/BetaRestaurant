package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 5/31/17.
 */

@Entity
public class RestaurantBranch
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_branch_seq")
    @SequenceGenerator(name="restaurant_branch_seq", sequenceName = "restaurant_branch_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private Restaurant restaurant;

    private String arabicName;
    private String englishName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToOne
    private Employee branchManager;

    public RestaurantBranch() { }

    public RestaurantBranch(Restaurant restaurant, String arabicName, String englishName, Address address) {
        this.restaurant = restaurant;
        this.arabicName = arabicName;
        this.englishName = englishName;
        this.address = address;
    }

    public RestaurantBranch(Restaurant restaurant, String arabicName, String englishName, Address address, Employee branchManager) {
        this.restaurant = restaurant;
        this.arabicName = arabicName;
        this.englishName = englishName;
        this.address = address;
        this.branchManager = branchManager;
    }

    public Employee getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(Employee branchManager) {
        this.branchManager = branchManager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
