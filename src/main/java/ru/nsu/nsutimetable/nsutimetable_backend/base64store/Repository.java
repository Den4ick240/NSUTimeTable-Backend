package ru.nsu.nsutimetable.nsutimetable_backend.base64store;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Repository extends MongoRepository<Base64Entity, String> {
//    Optional<Base64Entity> findBase64EntityByBaseStringAndUsername(String baseString, String username);
    Base64Entity findBase64EntityByBaseString(String baseString);
    Base64Entity findBase64EntityByBaseStringAndUsername(String baseString, String username);
    List<Base64Entity> findBase64EntitiesByUsername(String username);
}
