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

        //Bean Scope can create
        CommentService commentService1 = context.getBean(CommentService.class);
        CommentService commentService2 = context.getBean(CommentService.class);
        //printing the memory locations
        System.out.println(commentService1);
        System.out.println(commentService2);
        //verify if they are the same objects, it will print false if you comment the
        //scope annotation in CommentService, otherwise it prints true
        //if you want different object, must implement the Prototype scope
        System.out.println(commentService1 == commentService2);
    }
}
