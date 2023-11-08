package com.mycy.loosely_coupled;

public class MentorApp {

    public static void main(String[] args) {
        //create objects of the implementing classes

        //PartTimeMentor partTime = new PartTimeMentor();
        FullTimeMentor fullTime = new FullTimeMentor();

        //creating an object of the manager class to call the method
        // that calls the implementing methods
       MentorManager mentorManager = new MentorManager(fullTime);
       mentorManager.manageAccount();
    }
}
