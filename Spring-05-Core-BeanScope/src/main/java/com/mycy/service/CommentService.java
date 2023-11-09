package com.mycy.service;

import com.mycy.model.Comment;
import com.mycy.proxy.CommentNotificationProxy;
import com.mycy.proxy.CommentPushNotificationProxy;
import com.mycy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 Spring is singleton by default, multiple references will point to the same object.
 There are rare cases that you might need a different bean. If you face certain
 challenges with a bean, the solution is to use a prototype scope.
 The @Scope("prototype") tells spring to create additional object whenever requested
 If you use @Lazy annotation Spring context will not create beans automatically by default
 unless you call or create object of it in the runner class
 Do not use both the @Scope("prototype") and the @Lazy annotations at the same time.
*/
@Component//tells spring context to create a bean from this class
@Scope("prototype")
//@Lazy
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
