package com.module1.tp1.modules.user;

import com.module1.tp1.modules.user.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
  @Autowired
  private UserService userService;

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> create(@Valid @RequestBody User user) {
    User userCreated = userService.createUser(user);
    return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
  }
}
