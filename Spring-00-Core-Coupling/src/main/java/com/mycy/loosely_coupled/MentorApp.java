package com.mycy.loosely_coupled;

public class MentorApp {

    public static void main(String[] args) {
        //create objects of the implementing classes
        FullTimeMentor fullTime = new FullTimeMentor();
        //PartTimeMentor partTime = new PartTimeMentor();

        //pass the object to pass the implementing method of the object
        MentorManager mentor = new MentorManager(fullTime);
        mentor.manageAccount();
    }
}
