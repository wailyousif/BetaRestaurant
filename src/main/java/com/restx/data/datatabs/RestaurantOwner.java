package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/10/17.
 */

@Entity
public class RestaurantOwner
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_owner_seq")
    @SequenceGenerator(name="restaurant_owner_seq", sequenceName = "restaurant_owner_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ContactInfo contactInfo;

    public RestaurantOwner() { }

    public RestaurantOwner(String name, ContactInfo contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
