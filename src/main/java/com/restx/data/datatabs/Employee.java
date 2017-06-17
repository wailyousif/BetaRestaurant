package com.restx.data.datatabs;

import com.restx.data.codestabs.JobType;
import com.restx.data.codestabs.SalaryFrequency;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wailm.yousif on 5/30/17.
 */

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name="employee_seq", sequenceName = "employee_seq", allocationSize = 1, initialValue = 1)
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

    public Employee() { }
}
