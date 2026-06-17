package com.SBMS.SBMS;

import com.SBMS.SBMS.External.UserApiClient;
import com.SBMS.SBMS.Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class SbmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(SbmsApplication.class, args);
        final UserService userService = new UserService(new UserApiClient(RestClient.builder().build()));
        userService.printUser();

    }

}
