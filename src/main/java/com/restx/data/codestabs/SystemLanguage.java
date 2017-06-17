package com.restx.data.codestabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/16/17.
 */

@Entity
public class SystemLanguage
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_language_seq")
    @SequenceGenerator(name="system_language_seq", sequenceName = "system_language_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String language;

    public SystemLanguage(String language) {
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
