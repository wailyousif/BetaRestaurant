package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/6/17.
 */

@Entity
public class WaiterAccumulator
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waiter_accumulator_seq")
    @SequenceGenerator(name="waiter_accumulator_seq", sequenceName = "waiter_accumulator_seq", allocationSize = 1, initialValue = 1)
    private long id;

    @OneToOne
    private Employee employee;

    private double ordersTotalAmount;

    public WaiterAccumulator() { }
}
