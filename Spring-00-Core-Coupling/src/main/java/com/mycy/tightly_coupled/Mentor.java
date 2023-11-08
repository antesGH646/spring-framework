package com.mycy.tightly_coupled;

public class Mentor {
    //Defining the class instances
    FullTimeMentor fullTimeMentor;
    PartTimeMentor partTimeMentor;

    //initializing the class instances in a constructor
    public Mentor(FullTimeMentor fullTimeMentor, PartTimeMentor partTimeMentor) {
        this.fullTimeMentor = fullTimeMentor;
        this.partTimeMentor = partTimeMentor;
    }

    //using the instances to call methods
    public void manageAccount(){
        fullTimeMentor.createAccount();
        partTimeMentor.createAccount();
    }
}
