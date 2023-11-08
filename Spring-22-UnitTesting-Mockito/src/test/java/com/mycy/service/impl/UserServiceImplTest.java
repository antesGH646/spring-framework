package com.mycy.service.impl;

import com.mycy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

//allows to use Mockito methods and classes on the top of the JUnit and TestNG
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock//telling mockito to mock from this repository
    UserRepository userRepository;

    //No constructor, b/c don't want to inject the real object, just want to inject the mock
    @InjectMocks
    UserServiceImpl userServiceImpl;


    //mocking deleteByUsername() method
    @Test
    void deleteByUserNameTest() {
        //when you call this method it will run the Mockito.verify() instead
        userServiceImpl.deleteByUserName("mikesmith@cydeo.com");

        //it will go to the method but will not execute the method
        verify(userRepository).deleteByUserName("mikesmith@cydeo.com");

        //it runs the mock n times, sometimes the same line of code in a method may run > 1 times
        //verify(userRepository, times(2)).deleteByUserName("mikesmith@cydeo.com");

        //makes sure to run at least one time
        verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@cydeo.com");

        //amy run one time or not run
        verify(userRepository, atMostOnce()).deleteByUserName("mikesmith@cydeo.com");

        //checks if the lines of code under are running according to the order in the implementing method
        InOrder inOrder = inOrder(userRepository);
        inOrder.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
        inOrder.verify(userRepository).findAll();//if you move up this line the test fails
    }
}