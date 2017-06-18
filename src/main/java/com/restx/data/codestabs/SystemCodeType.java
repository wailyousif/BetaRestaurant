package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/18/17.
 */

@Entity
public class SystemCodeType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_code_type_seq")
    @SequenceGenerator(name="system_code_type_seq", sequenceName = "system_code_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(unique = true)
    private String codeType;

    private String description;

    public SystemCodeType() { }

    public SystemCodeType(String codeType, String description) {
        this.codeType = codeType;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
