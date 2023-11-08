package com.mycy.repository;

import com.mycy.model.Comment;

//cannot get @Component, because interfaces cannot be instantiated
public interface CommentRepository {
    void storeComment(Comment comment);
}
