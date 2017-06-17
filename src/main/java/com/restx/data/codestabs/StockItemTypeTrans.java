package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/18/17.
 */

@Entity
public class StockItemTypeTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private StockItemType stockItemType;

    private String langDescription;

    public StockItemTypeTrans() { }

    public StockItemTypeTrans(String langCode, SystemLanguage language, StockItemType stockItemType, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.stockItemType = stockItemType;
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

    public StockItemType getStockItemType() {
        return stockItemType;
    }

    public void setStockItemType(StockItemType stockItemType) {
        this.stockItemType = stockItemType;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
