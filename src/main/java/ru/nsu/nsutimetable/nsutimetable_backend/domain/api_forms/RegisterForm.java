package ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.ValidPassword;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
    @Email
    private String username;
    @ValidPassword
    private String password;
}
