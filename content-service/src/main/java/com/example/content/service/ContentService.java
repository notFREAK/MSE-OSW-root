package com.example.content.service;

import com.example.content.model.ContentItem;
import com.example.content.repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public List<ContentItem> getAllContentItems() {
        return contentRepository.findAll();
    }

    public Optional<ContentItem> getContentItemById(String id) {
        return contentRepository.findById(id);
    }

    public ContentItem createContentItem(ContentItem contentItem) {
        Date now = new Date();
        contentItem.setCreatedAt(now);
        contentItem.setUpdatedAt(now);
        return contentRepository.save(contentItem);
    }

    public ContentItem updateContentItem(String id, ContentItem updatedContent) {
        return contentRepository.findById(id)
                .map(item -> {
                    item.setEventId(updatedContent.getEventId());
                    item.setSeatingPlan(updatedContent.getSeatingPlan());
                    item.setMultimedia(updatedContent.getMultimedia());
                    item.setUpdatedAt(new Date());
                    return contentRepository.save(item);
                }).orElseThrow(() -> new RuntimeException("Content item not found"));
    }

    public Optional<ContentItem> getContentItemByEventId(String eventId) {
        return contentRepository.findByEventId(eventId);
    }
    
    public void deleteContentItem(String id) {
        contentRepository.deleteById(id);
    }
}
