package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
//@Data
@Getter
@Setter
@Table(name="account_details")
public class Account extends BaseEntity{
    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;//assign the user directly

    @OneToOne(mappedBy = "account")//give ownership to the Account object
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                '}';
    }
}
