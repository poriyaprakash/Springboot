package com.example.demo.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "demo_entries")
public class DemoEntry {
    @Id
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

    private Date date;
}
