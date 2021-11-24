package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.AppUser;
import ru.nsu.nsutimetable.nsutimetable_backend.service.AppUserService;


@Controller
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final AppUserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
