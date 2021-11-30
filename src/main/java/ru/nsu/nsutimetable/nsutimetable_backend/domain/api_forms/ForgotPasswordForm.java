package ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ForgotPasswordForm {
    @Email
    private String email;
}
