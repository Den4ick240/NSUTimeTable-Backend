package ru.nsu.nsutimetable.nsutimetable_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.AppUser;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.UsernameAlreadyExistsException;
import ru.nsu.nsutimetable.nsutimetable_backend.repository.AppUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveUser(AppUser appUser) throws TableException {
        log.info("Saving new user {} to db", appUser.getUsername());
        if (userRepository.findById(appUser.getUsername()).isPresent())
            throw new UsernameAlreadyExistsException("Username already exists");
        return userRepository.save(appUser);
    }

    @Override
    public AppUser getUser(String username) throws UsernameNotFoundException {
        log.info("Fetching user {}", username);
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("No user with such username"));
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = getUser(username);
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
