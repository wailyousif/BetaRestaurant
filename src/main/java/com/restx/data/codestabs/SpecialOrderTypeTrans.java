package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/18/17.
 */

@Entity
public class SpecialOrderTypeTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private SpecialOrderType specialOrderType;

    private String langDescription;

    public SpecialOrderTypeTrans() { }

    public SpecialOrderTypeTrans(String langCode, SystemLanguage language, SpecialOrderType specialOrderType, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.specialOrderType = specialOrderType;
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

    public SpecialOrderType getSpecialOrderType() {
        return specialOrderType;
    }

    public void setSpecialOrderType(SpecialOrderType specialOrderType) {
        this.specialOrderType = specialOrderType;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
