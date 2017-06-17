package com.restx.data.codestabs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by wailm.yousif on 6/17/17.
 */

@Entity
public class SalaryFrequencyTrans
{
    @Id
    private String langCode;

    @ManyToOne
    private SystemLanguage language;

    @ManyToOne
    private SalaryFrequency salaryFrequency;

    private String langDescription;

    public SalaryFrequencyTrans() { }

    public SalaryFrequencyTrans(String langCode, SystemLanguage language, SalaryFrequency salaryFrequency, String langDescription) {
        this.langCode = langCode;
        this.language = language;
        this.salaryFrequency = salaryFrequency;
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

    public SalaryFrequency getSalaryFrequency() {
        return salaryFrequency;
    }

    public void setSalaryFrequency(SalaryFrequency salaryFrequency) {
        this.salaryFrequency = salaryFrequency;
    }

    public String getLangDescription() {
        return langDescription;
    }

    public void setLangDescription(String langDescription) {
        this.langDescription = langDescription;
    }
}
