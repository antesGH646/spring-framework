package com.cydeo.loosely_coupled;

public class CydeoApp {

    public static void main(String[] args) {
        //create objects of the implementing classes
        FullTimeMentor fullTime = new FullTimeMentor();
        //PartTimeMentor partTime = new PartTimeMentor();

        //pass the object to pass the implementing method of the object
        MentorAccount mentor = new MentorAccount(fullTime);
        mentor.manageAccount();
    }
}
