package com.mycy;

import com.mycy.model.Comment;
import com.mycy.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CommentApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Adam Smith");
        comment.setText("Wealth of Nations");

        //in real application we do not store it in an object
       ApplicationContext context =
               SpringApplication.run(CommentApplication.class, args);

       CommentService cs = context.getBean(CommentService.class);
       cs.publishComment(comment);
    }

}
