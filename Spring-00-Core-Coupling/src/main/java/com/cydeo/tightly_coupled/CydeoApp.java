package com.cydeo.tightly_coupled;

public class CydeoApp {
    public static void main(String[] args) {
        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        Mentor mentor = new Mentor(fullTime,partTime);
        mentor.manageAccount();
    }
}
