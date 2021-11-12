package com.jm.project.schooljournal.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Size(min = 6, max = 25)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String role;
}
