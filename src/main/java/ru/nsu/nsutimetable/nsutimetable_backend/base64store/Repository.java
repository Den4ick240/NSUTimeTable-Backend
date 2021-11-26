package ru.nsu.nsutimetable.nsutimetable_backend.base64store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Base64Entity, String> {
}
