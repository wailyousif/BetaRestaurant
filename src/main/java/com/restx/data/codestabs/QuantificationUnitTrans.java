package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/17/17.
 */

@Entity
public class QuantificationUnitTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private QuantificationUnit quantificationUnit;

    private String langDescription;

    public QuantificationUnitTrans() { }

    public QuantificationUnitTrans(String langCode, SystemLanguage language, QuantificationUnit quantificationUnit, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.quantificationUnit = quantificationUnit;
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

    public QuantificationUnit getQuantificationUnit() {
        return quantificationUnit;
    }

    public void setQuantificationUnit(QuantificationUnit quantificationUnit) {
        this.quantificationUnit = quantificationUnit;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
