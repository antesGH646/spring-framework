package com.mycy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="regions")
@NoArgsConstructor
@Data
public class Region extends BaseEntity{
    private String region;
    private String country;

    //if you don't tell Hibernate which table own the FK, it will create FK on both tables
    @OneToOne(mappedBy = "region")//marks not to create foreign key, FK ownership belongs to Employees table
    private Employee employee;//has-a-relationship

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
