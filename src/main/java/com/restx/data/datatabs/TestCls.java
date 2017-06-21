package com.restx.data.datatabs;

import com.restx.data.codestabs.StockTransactionType;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/21/17.
 */

@Entity
public class TestCls
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_cls_seq")
    @SequenceGenerator(name="test_cls_seq", sequenceName = "test_cls_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private StockTransactionType stockTransactionType;

    private String str;

    public TestCls() { }

    public TestCls(StockTransactionType stockTransactionType, String str) {
        this.stockTransactionType = stockTransactionType;
        this.str = str;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StockTransactionType getStockTransactionType() {
        return stockTransactionType;
    }

    public void setStockTransactionType(StockTransactionType stockTransactionType) {
        this.stockTransactionType = stockTransactionType;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
