package com.cydeo.loosely_coupled;

public class MentorManager {

    //defining the interface's reference instead of the instances of the implementing classes
    Mentor mentor;

    //initializing the reference, later it will accept the objects of the implementing classes
    public MentorManager(Mentor mentor) {
        this.mentor = mentor;
    }

    //a method that calls an implementing method of any implementing class
    public void manageAccount(){
        this.mentor.createAccount();
    }
}
