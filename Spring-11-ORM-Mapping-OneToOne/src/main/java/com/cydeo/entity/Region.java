package com.cydeo.entity;

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

    @OneToOne(mappedBy = "region")//marks not to create foreign key, employee has ownership
    private Employee employee;//has-a-relationship

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
