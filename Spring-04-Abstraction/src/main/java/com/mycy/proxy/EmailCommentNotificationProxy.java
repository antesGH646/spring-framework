package com.mycy.proxy;

import com.mycy.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Component is used to mark this class to redirect the Spring to create a bean from it
 * Qualifier is used to
 */
@Component
//@Primary //to tell Spring to create a default bean from this class
@Qualifier("EMAIL")//customizing since the class name is too long
public class EmailCommentNotificationProxy implements CommentNotificationProxy{

    //suppose that this method is implementing a business logic, this is how the abstract design works
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification implementation");
    }
}
