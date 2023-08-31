package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.CommentPushNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*
Spring is singleton by default, multiple references will point to the same object.
there are rare cases, you may need different bean, the solution is to use prototype scope
 */
@Scope("prototype")//tells spring to create another object whenever requested
//@Lazy //will not create beans automatically by default unless you call or create object of it in the runner class
public class CommentService {
    //if you have dependency make them private final, common practice
    //these are dependency classes we do not change anything, that why they are private final
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentPushNotificationProxy commentPushNotificationProxy;

    //if you have final you need to make a constructor and initialize
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy, CommentPushNotificationProxy commentPushNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentPushNotificationProxy = commentPushNotificationProxy;
        //added to check if an object is created or not
        System.out.println("Lazy instantiating without calling an object");
    }

    //create a method that stores and sends a comment
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
        commentPushNotificationProxy.sendComment(comment);
    }
}
