package com.mycy.loosely_coupled;

public class MentorApp {

    public static void main(String[] args) {
        //create objects of the implementing classes
        FullTimeMentor fullTime = new FullTimeMentor();
        //PartTimeMentor partTime = new PartTimeMentor();

        //creating an object of the manager class to call the method
        // that calls the implementing methods
        MentorManager mentor = new MentorManager(fullTime);
        mentor.manageAccount();
    }
}
