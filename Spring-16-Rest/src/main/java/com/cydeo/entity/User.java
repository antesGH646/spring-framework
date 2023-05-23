package com.cydeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * the @JsonManagedReference is used when there is relationship
 * e.g the Account will show up in the User
 * the @JsonManagedReference is the forward part of reference
 * – the one that gets serialized normally. @JsonBackReference is
 * the back part of reference – it will be omitted from serialization.
 * When Jackson finds the (fetch = FetchType.LAZY) it creates the
 * hibernateLazyInitializer field automatically. So, ignore this field too.
 * (access = JsonProperty.Access.WRITE_ONLY) if you want to see the password
 * when you Post but not show it when Get
 * cannot ignore on one-to-one relationships
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class User extends BaseEntity {

//    @JsonIgnore
    private String email;

    //to see it when you Post but ignored when you Get
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference //is the forward part of reference - the one that gets serialized normally
    private Account account;

}
