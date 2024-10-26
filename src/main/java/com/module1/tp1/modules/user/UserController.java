package com.module1.tp1.modules.user;

import com.module1.tp1.modules.user.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This controller will manage the user registration
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  private UserService userService;


  @PostMapping("/create")
  public ResponseEntity<UserResponse> create(@Valid @RequestBody User user) {
    User createdUser = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.toUserResponse(createdUser));
  }

  @GetMapping("/getAll")
  public Iterable<User> getAll() {
    return userService.getAll();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public String handleDuplicateUsernameException(RuntimeException e) {
    return e.getMessage();
  }
}
