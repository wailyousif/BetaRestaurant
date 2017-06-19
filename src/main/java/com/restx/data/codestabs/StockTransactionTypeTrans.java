package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/17/17.
 */

@Entity
public class StockTransactionTypeTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private StockTransactionType stockTransactionType;

    private String langDescription;

    public StockTransactionTypeTrans() { }

    public StockTransactionTypeTrans(String langCode, SystemLanguage language, StockTransactionType stockTransactionType, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.stockTransactionType = stockTransactionType;
        this.langDescription = langDescription;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public SystemLanguage getLanguage() {
        return language;
    }

    public void setLanguage(SystemLanguage language) {
        this.language = language;
    }

    public StockTransactionType getStockTransactionType() {
        return stockTransactionType;
    }

    public void setStockTransactionType(StockTransactionType stockTransactionType) {
        this.stockTransactionType = stockTransactionType;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
