package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/20/17.
 */

@Entity
public class StockTransactionType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_transaction_type_seq")
    @SequenceGenerator(name="stock_transaction_type_seq", sequenceName = "stock_transaction_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String code;    //Add to Stock, Remove from Stock, Move from Stock to Kitchen, Move from Kitchen to Stock

    private boolean userDefined;

    public StockTransactionType() { }

    public StockTransactionType(String code, boolean userDefined) {
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
