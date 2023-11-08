package com.mycy.service;

import com.mycy.model.Comment;
import com.mycy.proxy.CommentNotificationProxy;
import com.mycy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * All the implementing class variables are defined and corresponding methods are
 * created in services class
 * 1) implementing class variables are defined
 * 2) the variable references are initialized inside the constructor
 *   If more than classes are implementing the same interface, make sure to tell
 *   the Spring which object to inject using the @Qualifier annotation, or use the
 *  Primary annotation to avoid getting exception.
 * 3) a corresponding methods are created to implement the business logic
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
