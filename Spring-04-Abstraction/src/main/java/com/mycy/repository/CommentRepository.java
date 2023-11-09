package com.mycy.repository;

import com.mycy.model.Comment;

//cannot add @Component annotation, because interfaces cannot be instantiated
public interface CommentRepository {
    void storeComment(Comment comment);
}
