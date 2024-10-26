package com.module1.tp1.modules.user;

import com.module1.tp1.modules.configuration.ConfigurationService;
import com.module1.tp1.modules.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ConfigurationService configurationService;

  public User createUser(User user) {
    this.configurationService.getLoggingService().log("UserService: Creating user.");
    String encryptedPassword = this.configurationService.getEncryptionService().encrypt(user.getPassword());
    user.setPassword(encryptedPassword);
    try {
      this.configurationService.getLoggingService().log("UserService: User created successfully.");
      return userRepository.save(user);
    } catch (Exception e) {
      throw new RuntimeException("Username is already taken.");
    }
  }

  public User getUserByUsername(String username) {
    this.configurationService.getLoggingService().log("UserService: Getting user by username: " + username + ".");
    return userRepository.findByUsername(username);
  }

  public UserResponse toUserResponse(User user) {
    return new UserResponse(
      user.getId(),
      user.getUsername(),
      user.getFirstName(),
      user.getLastName(),
      user.getPhoneNumber()
    );
  }

  public boolean isPasswordCorrect(String plainPassword, String encryptedPassword) {
    return this.configurationService.getEncryptionService().verify(plainPassword, encryptedPassword);
  }

  public Iterable<User> getAll() {
    this.configurationService.getLoggingService().log("UserService: Getting all the users registered.");
    return userRepository.findAll();
  }
}
