package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Component is used to mark this class to redirect the Spring to create a bean from it
 * Qualifier is used to
 */
@Component
//@Primary //to tell Spring to create a default bean from this class
@Qualifier("EMAIL")//using custom in case the class names are too long
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification implementation");
    }
}
