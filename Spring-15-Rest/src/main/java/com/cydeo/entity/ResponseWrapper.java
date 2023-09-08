package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * This custom mapper is used to add custom messages into
 * the Json response. It Can pass the messages by calling the
 * constructor under the body() method of the ResponseEntity class
 * e.g. .body(new ResponseWrapper("message",courseService.getCourses()))
 */
@Getter//Jackson needs Getters and Setters to map
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }
}
