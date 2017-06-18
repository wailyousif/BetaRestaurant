package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/18/17.
 */

@Entity
public class SystemCode
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_code_seq")
    @SequenceGenerator(name="system_code_seq", sequenceName = "system_code_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String code;

    @ManyToOne
    private SystemCodeType systemCodeType;

    private boolean userDefined;

    private int listOrder;

    public SystemCode() { }

    public SystemCode(String code, SystemCodeType systemCodeType, boolean userDefined, int listOrder) {
        this.code = code;
        this.systemCodeType = systemCodeType;
        this.userDefined = userDefined;
        this.listOrder = listOrder;
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

    public SystemCodeType getSystemCodeType() {
        return systemCodeType;
    }

    public void setSystemCodeType(SystemCodeType systemCodeType) {
        this.systemCodeType = systemCodeType;
    }

    public boolean isUserDefined() {
        return userDefined;
    }

    public void setUserDefined(boolean userDefined) {
        this.userDefined = userDefined;
    }

    public int getListOrder() {
        return listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }
}
