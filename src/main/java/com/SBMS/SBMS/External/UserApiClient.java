package com.SBMS.SBMS.External;

import com.SBMS.SBMS.Dto.UsersResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserApiClient {
    private final RestClient restClient;

    public UserApiClient(RestClient restClient) {
        this.restClient = restClient;
    }


    public UsersResponse getUser() {
        try {
            return restClient.get().uri("https://jsonplaceholder.typicode.com/users")
                    .retrieve()
                    .body(UsersResponse.class);
        } catch (Exception ex) {
            System.out.printf(ex.getLocalizedMessage());
            throw new RuntimeException("Faild to fetch users from DummyJson API {}", ex);
        }
    }
}
