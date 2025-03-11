package com.example.auth.client;

import com.example.auth.dto.UserDto;
import com.example.auth.dto.UserRegistrationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service")
public interface UserManagementClient {

    @GetMapping("/api/v1/users/email/{email}")
    UserDto getUserByEmail(@PathVariable("email") String email);

    @PostMapping("/api/v1/users")
    UserDto createUser(@RequestBody UserRegistrationRequest request);
}
