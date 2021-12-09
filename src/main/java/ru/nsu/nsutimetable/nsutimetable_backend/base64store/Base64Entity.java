package ru.nsu.nsutimetable.nsutimetable_backend.base64store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Base64Entity {
    public Base64Entity(String string, String username) {
        baseString = string;
        this.username = username;

    }
    @Id
    private String id;
    @Unique
    private String baseString;

    private String username;
}