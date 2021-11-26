package ru.nsu.nsutimetable.nsutimetable_backend.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.RegisterForm;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    private String username;
    private String password;

    public AppUser(RegisterForm registerForm) {
        username = registerForm.getUsername();
        password = registerForm.getPassword();
    }
}
