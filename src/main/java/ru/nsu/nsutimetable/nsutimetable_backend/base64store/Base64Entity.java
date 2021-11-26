package ru.nsu.nsutimetable.nsutimetable_backend.base64store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Base64Entity {
    public Base64Entity(String string) {
        baseString = string;
    }
    @Id
    private String id;
    private String baseString;
}