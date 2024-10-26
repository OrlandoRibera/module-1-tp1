package com.module1.tp1.modules.logging;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "logs")
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String message;

  public Log(String message) {
    this.message = message;
  }
}
