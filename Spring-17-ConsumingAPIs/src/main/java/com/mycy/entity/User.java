package com.mycy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"},ignoreUnknown = true)
public class User extends BaseEntity {

    //@JsonIgnore
    private String email;

    //JsonProperty.Access.WRITE_ONLY enables user to include the password in the request body,
    // but it will not be serialized (will not display in the response body)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference //is the forward part of reference - the one that gets serialized normally
    private Account account;

}
