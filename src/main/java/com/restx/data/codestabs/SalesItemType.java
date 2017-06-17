package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class SalesItemType
{
    @Id
    private String code;    //Sandwich, Appetizer, Dish, Desert, Drink, etc.

    private boolean userDefined;

    public SalesItemType() { }

    public SalesItemType(String code, boolean userDefined) {
        this.code = code;
        this.userDefined = userDefined;
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
