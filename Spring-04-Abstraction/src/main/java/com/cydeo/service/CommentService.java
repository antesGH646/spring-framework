package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The service package is used to store the manager class that defines references of all
 * the implementing classes and initializes the references in the constructor. In this
 * class all the implementing classes' references are encapsulated. Corresponding methods
 * are created in the manager class too.
 * Flow:
 * 1) define encapsulated reference variables of the implementing classes, make them private and final
 * when you are using private and final you are required to initialize them using a constructor
 * 2) the variable references are initialized inside the constructor
 *   If more than classes are implementing the same interface, make sure to tell
 *   the Spring which object to inject using the @Qualifier annotation, or use the
 *  Primary annotation to avoid getting an exception.
 * 3) corresponding methods are created to implement the business logic
 */
@Component
public class CommentService {
    //if you have dependency make them private final, common practice
    //these are constant dependencies (dependencies that don't change anything)
    // that is why they are private final
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentNotificationProxy commentNotificationProxy2;

    //if you have final you need to make a constructor and initialize
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("commentPushNotificationProxy")
                        //  @Qualifier("PUSH")
                          CommentNotificationProxy commentNotificationProxy,
                          @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy2) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentNotificationProxy2 = commentNotificationProxy2;
    }

    //suppose that this method stores and sends user generated comments
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
        commentNotificationProxy2.sendComment(comment);
    }
}
