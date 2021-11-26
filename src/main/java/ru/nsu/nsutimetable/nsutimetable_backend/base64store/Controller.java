package ru.nsu.nsutimetable.nsutimetable_backend.base64store;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/base64")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class Controller {
    private final Repository repository;

    @GetMapping("{id}")
    public String get(@PathVariable String id) {
        return repository.findById(id).map(b -> b.getBaseString()).orElse("");
    }

    @PostMapping("{string}")
    public String post(@PathVariable String string) {
        return repository.insert(new Base64Entity(string)).getId();
    }
}
