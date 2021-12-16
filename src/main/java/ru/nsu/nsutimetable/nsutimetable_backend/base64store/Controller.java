package ru.nsu.nsutimetable.nsutimetable_backend.base64store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.nsutimetable.nsutimetable_backend.service.UsernameProvider;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "${corshosts}")
@RequestMapping()
@RequiredArgsConstructor
public class Controller {
    private final Repository repository;
    private final UsernameProvider usernameProvider;

    @GetMapping("{id}")
    public String get(@PathVariable String id) {
        return repository.findById(id).map(b -> b.getBaseString()).orElse("");
    }



    @PostMapping()
    public ResponseEntity<String> post(@RequestBody BaseStringHolder baseStringHolder) {
        String username = usernameProvider.getUsername();

        if (repository.findBase64EntitiesByUsername(username).size() > 10)
            return ResponseEntity.status(429).build();

        Base64Entity entity;
        String _string = baseStringHolder.getString();
        String string = _string;
        System.out.println(string);
        var optional = repository.findBase64EntityByBaseStringAndUsername(string, username);
        System.out.println(optional);
        entity = Optional.ofNullable(optional)
                .orElseGet(() ->
                        repository.insert(new Base64Entity(string, username))
                );
        return ResponseEntity.ok(entity.getId());
    }
}
