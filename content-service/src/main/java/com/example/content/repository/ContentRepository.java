package com.example.content.repository;

import com.example.content.model.ContentItem;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends MongoRepository<ContentItem, String> {
    Optional<ContentItem> findByEventId(String eventId);
}
