package com.evertonreis.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginDto {

    @Email(message = "Invalid email address!")
    private String email;

    @NotBlank
    private String senha;
}
