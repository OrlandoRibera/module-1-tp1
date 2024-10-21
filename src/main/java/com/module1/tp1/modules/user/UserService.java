package com.module1.tp1.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User getUser(Long id) {
    Optional<User> userFound = userRepository.findById(id);
    return userFound.orElse(null);
  }
}
