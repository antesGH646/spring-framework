package com.cydeo;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Spring18RestOpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring18RestOpenApi3Application.class, args);
    }

    /**
     * title() displays the title on the Swagger page documentation page
     * version() displays the version on the Swagger documentation page
     * description() displays the description on the Swagger documentation page
     * the @return
     */
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
//                .servers()
//                .path(new Paths().addPathItem("", new PathItem().get())
//                .components(new Components())
                .info(new Info()
                        .title("Cinema Application OpenAPI")
                        .version("v1")
                        .description("Cinema Application API Documentation"));
    }
}
