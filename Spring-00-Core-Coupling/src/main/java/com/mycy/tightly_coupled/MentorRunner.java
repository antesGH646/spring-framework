package com.mycy.tightly_coupled;

public class MentorRunner {
    public static void main(String[] args) {
        //creating instances to pass them as arguments, b/c mentor accepts two instances
        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        //Mentor the managing class accepts two class instances as an arguments
        MentorMgr mentor = new MentorMgr(fullTime,partTime);

        //calling the mentor method that runs the methods of the component classes
        mentor.manageAccount();
    }
}
