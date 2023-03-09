package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The proxy classes occupies the interfaces and implementing classes that use the
 * attributes of the business logic.
 */
@Component
@Qualifier("PUSH") //if more than two classes are implementing the same interface, tell the Spring from
//which class to create a bean, this implementing class is marked with "PUSH" qualifier
public class CommentPushNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification: " + comment.getText());
    }
}
