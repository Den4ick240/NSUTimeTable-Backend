package ru.nsu.nsutimetable.nsutimetable_backend.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.users.AppUser;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser) throws TableException;
    AppUser getUser(String username) throws UsernameNotFoundException;
    List<AppUser> getUsers();
}
