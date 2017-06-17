package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class QuantificationUnit
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quantification_unit_seq")
    @SequenceGenerator(name="quantification_unit_seq", sequenceName = "quantification_unit_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String code;

    private boolean userDefined;

    @ManyToOne
    private QuantificationMethod quantificationMethod;

    public QuantificationUnit() { }

    public QuantificationUnit(String code, boolean userDefined, QuantificationMethod quantificationMethod) {
        this.code = code;
        this.userDefined = userDefined;
        this.quantificationMethod = quantificationMethod;
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

    public QuantificationMethod getQuantificationMethod() {
        return quantificationMethod;
    }

    public void setQuantificationMethod(QuantificationMethod quantificationMethod) {
        this.quantificationMethod = quantificationMethod;
    }
}
