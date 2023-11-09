package com.mycy.dto;

import com.mycy.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDTO {

    private Long id;//to transfer the id for the assigned user

    //getter for the id
    public Long getId() {
        return id;
    }
    //setter for the id
    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    @Size(max = 15, min = 2)
    private String firstName;

    @NotBlank
    @Size(max = 15, min = 2)
    private String lastName;

    @NotBlank
    @Email
    private String userName;

    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String passWord;

    @NotNull
    private String confirmPassWord;

    private boolean enabled;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String phone;

    @NotNull
    private RoleDTO role; //UserDTO has RoleDTO object dependency

    @NotNull
    private Gender gender;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        checkConfirmPassWord();
    }

    public String getConfirmPassWord() {
        return confirmPassWord;
    }

    public void setConfirmPassWord(String confirmPassWord) {
        this.confirmPassWord = confirmPassWord;
        checkConfirmPassWord();
    }

    private void checkConfirmPassWord() {
        if(this.passWord == null || this.confirmPassWord == null){
        }else if(!this.passWord.equals(confirmPassWord)){
            this.confirmPassWord = null;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}