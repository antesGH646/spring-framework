package com.mycy.tightly_coupled;

public class CydeoApp {
    public static void main(String[] args) {
        //creating instances to pass them as arguments, b/c mentor accepts two instances
        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        //Mentor the managing class accepts two class instances as an arguments
        Mentor mentor = new Mentor(fullTime,partTime);

        //calling the mentor method that runs the methods of the component classes
        mentor.manageAccount();
    }
}
