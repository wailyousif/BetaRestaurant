package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/6/17.
 */

@Entity
public class SpecialOrderType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "special_order_type_seq")
    @SequenceGenerator(name="special_order_type_seq", sequenceName = "special_order_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String code;        //Open Buffet, Junket or Wedding

    private boolean userDefined;

    public SpecialOrderType() { }

    public SpecialOrderType(String code, boolean userDefined) {
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
