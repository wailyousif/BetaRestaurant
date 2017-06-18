package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/18/17.
 */

@Entity
public class SystemCodeTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private SystemCode systemCode;

    private String langDescription;

    public SystemCodeTrans() { }

    public SystemCodeTrans(String langCode, SystemLanguage language, SystemCode systemCode, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.systemCode = systemCode;
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

    public SystemCode getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(SystemCode systemCode) {
        this.systemCode = systemCode;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
