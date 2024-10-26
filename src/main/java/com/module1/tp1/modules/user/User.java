package com.module1.tp1.modules.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull(message = "username is required.")
  @Column(unique = true)
  private String username;
  @NotNull(message = "password is required.")
  private String password;
  @NotNull(message = "firstName is required.")
  private String firstName;
  @NotNull(message = "lastName is required.")
  private String lastName;
  private Integer phoneNumber;
}
