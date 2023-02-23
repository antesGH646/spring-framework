package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary //to tell which one to inject if there are many classes of the same type
@Qualifier("EMAIL")//using custom in case the names are long
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification implementation");
    }
}
