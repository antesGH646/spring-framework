package com.mycy.proxy;

import com.mycy.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary //to tell which one to inject if there are many classes of the same type
@Qualifier("EMAIL")//used for identification, if more than 1 classes are implementing an interface
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification implementation");
    }
}
