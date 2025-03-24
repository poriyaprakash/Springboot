package com.example.demo.repository;

import com.example.demo.entity.DemoEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoEntryRepository extends MongoRepository<DemoEntry, ObjectId> {

}


