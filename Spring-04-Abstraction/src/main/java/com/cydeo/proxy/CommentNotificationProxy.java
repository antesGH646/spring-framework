package com.cydeo.proxy;

import com.cydeo.model.Comment;

//cannot get @Component, because interfaces cannot be instantiated
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
