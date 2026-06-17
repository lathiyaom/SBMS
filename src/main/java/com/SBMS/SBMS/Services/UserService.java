package com.SBMS.SBMS.Services;

import com.SBMS.SBMS.Dto.UserDto;
import com.SBMS.SBMS.Dto.UsersResponse;
import com.SBMS.SBMS.External.UserApiClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserApiClient userApiClient;

    public UserService(UserApiClient userApiClient) {
        this.userApiClient = userApiClient;
    }

    public  void printUser() {
        UsersResponse response = userApiClient.getUser();
        for (UserDto user : response.users()) {

            System.out.println("--------------------------------");

            System.out.println("ID       : " + user.id());
            System.out.println("Name     : " + user.firstname() + " " + user.lastname());
            System.out.println("Email    : " + user.email());
            System.out.println("Phone    : " + user.phone());
            System.out.println("Username : " + user.username());

            System.out.println("--------------------------------");
        }

    }
}
