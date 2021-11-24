package ru.nsu.nsutimetable.nsutimetable_backend.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    private String username;
    private String password;
//    private Collection<Role> roles = new ArrayList<>();
}
