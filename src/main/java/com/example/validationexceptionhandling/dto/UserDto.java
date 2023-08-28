package com.example.validationexceptionhandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "username should not be null")
    private String name;
    @Email(message = "invalid email")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    private String nationality;

}
