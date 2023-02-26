package com.cydeo.tightly_coupled;

public class CydeoApp {
    public static void main(String[] args) {
        //making class instances to pass them as arguments
        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        //Mentor the managing class accepts two class instances as an arguments
        Mentor mentor = new Mentor(fullTime,partTime);
        mentor.manageAccount();
    }
}
