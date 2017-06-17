package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/2/17.
 */

@Entity
public class UserRole
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(name="user_role_seq", sequenceName = "user_role_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String role;
    private String description;
    private String defaultPage;

    public UserRole() { }

    public UserRole(String role, String description, String defaultPage) {
        this.role = role;
        this.description = description;
        this.defaultPage = defaultPage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }
}
