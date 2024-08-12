package com.ozgurucr.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "İsim boş bırakılamaz")
        String firstName,

        @NotEmpty
        String lastName,

        String email,

        Integer schoolId) {

}
