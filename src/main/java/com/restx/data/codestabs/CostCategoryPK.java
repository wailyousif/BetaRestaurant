package com.restx.data.codestabs;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by wailm.yousif on 6/17/17.
 */

@Embeddable
public class CostCategoryPK implements Serializable
{
    @Column(name = "code")
    private String code;  //Governmental, Employees Benefits, Rental, Utilities, Others

    @ManyToOne
    private SystemLanguage language;

    public CostCategoryPK() { }

    public CostCategoryPK(String code, SystemLanguage language) {
        this.code = code;
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SystemLanguage getLanguage() {
        return language;
    }

    public void setLanguage(SystemLanguage language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CostCategoryPK)) return false;
        CostCategoryPK that = (CostCategoryPK) o;
        return Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getLanguage().getId(), that.getLanguage().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getLanguage().getId());
    }
}
