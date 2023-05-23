package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

//Jackson needs Getters and Setters to map
@Getter
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
