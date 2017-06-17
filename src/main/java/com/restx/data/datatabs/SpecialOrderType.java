package com.restx.data.datatabs;

import javax.persistence.*;

/**
 * Created by wailm.yousif on 6/6/17.
 */

@Entity
public class SpecialOrderType
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "special_order_type_seq")
    @SequenceGenerator(name="special_order_type_seq", sequenceName = "special_order_type_seq", allocationSize = 1, initialValue = 1)
    private long id;

    private String specialOrderType;   //Open Buffet, Junket or Wedding
    private String description;

    public SpecialOrderType() { }
}
