package com.module1.tp1.modules.user;

import com.module1.tp1.modules.user.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller will manage the user registration
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponse> create(@RequestBody User user) {

    UserResponse userResponse = new UserResponse(1, user.getUsername(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
    return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
  }
}
