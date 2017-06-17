package com.restx.data.datatabs;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 3/27/17.
 */

@Entity
public class AuthToken
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_token_seq")
    @SequenceGenerator(name = "auth_token_seq", sequenceName = "auth_token_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String tokenString;
    private Date creationTime;
    private long numOfCalls;
    private Date lastCallTime;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId=true)
    private AppUser appUser;

    public AuthToken() { }

    public AuthToken(String tokenString, Date creationTime, long numOfCalls, Date lastCallTime, AppUser appUser) {
        this.tokenString = tokenString;
        this.creationTime = creationTime;
        this.numOfCalls = numOfCalls;
        this.lastCallTime = lastCallTime;
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public long getNumOfCalls() {
        return numOfCalls;
    }

    public void setNumOfCalls(long numOfCalls) {
        this.numOfCalls = numOfCalls;
    }

    public Date getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(Date lastCallTime) {
        this.lastCallTime = lastCallTime;
    }
}
