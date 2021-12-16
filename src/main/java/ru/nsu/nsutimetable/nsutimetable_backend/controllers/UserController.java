package ru.nsu.nsutimetable.nsutimetable_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.StudentInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.ForgotPasswordForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.api_forms.RegisterForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.AppUser;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.UsernameAlreadyExistsException;
import ru.nsu.nsutimetable.nsutimetable_backend.service.AppUserService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.UserStudentInfoService;
import ru.nsu.nsutimetable.nsutimetable_backend.service.UsernameProvider;

import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@CrossOrigin(origins = "${corshosts}")
public class UserController {
    private final AppUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserStudentInfoService userStudentInfoService;
    private final UsernameProvider usernameProvider;

    @PostMapping("user/save")
    public ResponseEntity<String> saveUser(@Valid @RequestBody RegisterForm registerForm) throws TableException {
        var user = new AppUser(registerForm);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            userService.saveUser(user);
        } catch (UsernameAlreadyExistsException e) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok("User created");
    }

    @PostMapping("student_info")
    public ResponseEntity saveStudentInfo(@RequestBody StudentInfo studentInfo) {
        userStudentInfoService.setStudentInfo(getUsername(), studentInfo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("student_info")
    public StudentInfo getStudentInfo() {
        return userStudentInfoService.getStudentInfo(getUsername());
    }

    @GetMapping("username")
    public String getUsername() {
        return usernameProvider.getUsername();
    }

    @PostMapping("user/password")
    private ResponseEntity forgotPassword(@RequestBody @Valid ForgotPasswordForm form) throws IOException {
        try {
            userService.getUser(form.getEmail());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(404).build();
        }

        FileWriter fw = new FileWriter("forgottenPasswords.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(form.getEmail());
        bw.newLine();
        bw.close();
        return ResponseEntity.ok().build();
    }

    @GetMapping("is_logged_in")
    private ResponseEntity<Boolean> isLoggedIn() {
        var auth = SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken);
        return ResponseEntity.ok(auth);
    }
}
