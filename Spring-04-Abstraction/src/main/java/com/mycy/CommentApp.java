package com.mycy;

import com.mycy.config.ProjectConfig;
import com.mycy.model.Comment;
import com.mycy.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Adam Smith");
        comment.setText("Wealth of Nations");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
