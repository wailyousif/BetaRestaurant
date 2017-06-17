package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class SalesItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_item_type_seq")
    @SequenceGenerator(name="sales_item_type_seq", sequenceName = "sales_item_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String code;    //Sandwich, Appetizer, Dish, Desert, Drink, etc.

    private boolean userDefined;

    public SalesItemType() { }

    public SalesItemType(String code, boolean userDefined) {
        this.code = code;
        this.userDefined = userDefined;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isUserDefined() {
        return userDefined;
    }

    public void setUserDefined(boolean userDefined) {
        this.userDefined = userDefined;
    }
}
