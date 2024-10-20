package com.module1.tp1.modules.auth;

import com.module1.tp1.modules.auth.dto.LoginRequest;
import com.module1.tp1.modules.user.dto.UserResponse;
import jakarta.validation.Valid;
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

  @PostMapping("/login")
  public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    String username = loginRequest.getUsername();
    String password = loginRequest.getPassword();

    UserResponse userResponse = new UserResponse(1, "abc", "def", "ghi", 123);
    return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
  }
}
