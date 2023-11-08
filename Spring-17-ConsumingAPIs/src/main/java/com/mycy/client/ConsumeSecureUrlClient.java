package com.mycy.client;

import com.mycy.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://dummyapi.io", name = "USER-CLIENT")
public interface ConsumeSecureUrlClient {

    @GetMapping("/data/v1/user/?limit=10")
    Employee getEmployee(@RequestHeader("app-id") String id);
}
