package com.example.resource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name = "users")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "First Name cannot be null")
  private String firstName;

  @NotNull(message = "Last Name cannot be null")
  private String lastName;

  @Min(value = 18, message = "Age should not be less than 18")
  @Max(value = 100, message = "Age should not be greater than 100")
  private int age;

  @Email(message = "Email should be valid")
  private String emailId;
}