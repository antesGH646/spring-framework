package com.mycy.proxy;

import com.mycy.model.Comment;

//cannot get @Component, because interfaces cannot be instantiated
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
