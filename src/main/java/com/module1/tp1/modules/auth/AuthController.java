package com.module1.tp1.modules.auth;

import com.module1.tp1.modules.auth.dto.LoginRequest;
import com.module1.tp1.modules.user.User;
import com.module1.tp1.modules.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller will manage the user authentication (Login)
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
    String username = loginRequest.username();
    String password = loginRequest.password();

    User user = userService.getUserByUsername(username);
    if (user == null) {
      return new ResponseEntity<>("Username not found.", HttpStatus.NOT_FOUND);
    }

    if (userService.isPasswordCorrect(password, user.getPassword())) {
      return new ResponseEntity<>("User logged successfully.", HttpStatus.ACCEPTED);
    }
    return new ResponseEntity<>("Username or password is incorrect.", HttpStatus.ACCEPTED);
  }
}