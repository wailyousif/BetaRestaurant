package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/17/17.
 */

@Entity
public class SalesItemTypeTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private SalesItemType salesItemType;

    private String langDescription;

    public SalesItemTypeTrans() { }

    public SalesItemTypeTrans(String langCode, SystemLanguage language, SalesItemType salesItemType, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.salesItemType = salesItemType;
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

    public SalesItemType getSalesItemType() {
        return salesItemType;
    }

    public void setSalesItemType(SalesItemType salesItemType) {
        this.salesItemType = salesItemType;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
