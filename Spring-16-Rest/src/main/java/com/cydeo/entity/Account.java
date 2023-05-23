package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * the @JsonIgnoreProperties is used to exclude/prevent some fields
 * from the response body. It can be placed on the class level or
 * on the field level,
 * the ignoreUnknown = true added for security reasons that is to block
 * any coming external fields from displaying or merging or integrating
 * the @JsonBackReference is used to omit the field from serialization
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
@JsonIgnoreProperties(value = {"state", "postalCode"},ignoreUnknown = true)
public class Account extends BaseEntity {

    private String name;
    @JsonIgnore
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    @JsonBackReference //is the back part of reference - it will be omitted from serialization
    private User user;

}
