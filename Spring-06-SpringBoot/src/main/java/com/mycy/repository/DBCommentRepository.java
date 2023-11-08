package com.mycy.repository;

import com.mycy.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing user comment: " + comment.getText());
    }
}
