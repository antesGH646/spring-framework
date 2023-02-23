package com.cydeo.repository;

import com.cydeo.model.Comment;

//cannot get @Component, because interfaces cannot be instantiated
public interface CommentRepository {
    void storeComment(Comment comment);
}
