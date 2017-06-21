package com.restx.data.datatabs;

import com.restx.data.codestabs.JobType;
import com.restx.data.codestabs.SalaryFrequency;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/30/17.
 */

@Entity
public class EmployeeHist
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_hist_seq")
    @SequenceGenerator(name="employee_hist_seq", sequenceName = "employee_hist_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private RestaurantBranch restaurantBranch;

    private String personalId;
    private String name;
    private String gender;
    private String jobTitle;

    @ManyToOne
    private JobType jobType;    //Cook, Waiter, Cashier, Finance, Others

    private String jobDescription;

    @ManyToOne
    private SalaryFrequency salaryFrequency;    //daily, weekly, monthly

    private double salary;
    private Date startDate;

    private Date creationTime;

    @ManyToOne
    private AppUser appUser;

    private String actionType;

    @ManyToOne
    private AppUser actionBy;

    public EmployeeHist() { }

    public EmployeeHist(RestaurantBranch restaurantBranch, String personalId, String name, String gender, String jobTitle, JobType jobType, String jobDescription, SalaryFrequency salaryFrequency, double salary, Date startDate, Date creationTime, AppUser appUser, String actionType, AppUser actionBy) {
        this.restaurantBranch = restaurantBranch;
        this.personalId = personalId;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.jobDescription = jobDescription;
        this.salaryFrequency = salaryFrequency;
        this.salary = salary;
        this.startDate = startDate;
        this.creationTime = creationTime;
        this.appUser = appUser;
        this.actionType = actionType;
        this.actionBy = actionBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RestaurantBranch getRestaurantBranch() {
        return restaurantBranch;
    }

    public void setRestaurantBranch(RestaurantBranch restaurantBranch) {
        this.restaurantBranch = restaurantBranch;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public SalaryFrequency getSalaryFrequency() {
        return salaryFrequency;
    }

    public void setSalaryFrequency(SalaryFrequency salaryFrequency) {
        this.salaryFrequency = salaryFrequency;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public AppUser getActionBy() {
        return actionBy;
    }

    public void setActionBy(AppUser actionBy) {
        this.actionBy = actionBy;
    }
}
