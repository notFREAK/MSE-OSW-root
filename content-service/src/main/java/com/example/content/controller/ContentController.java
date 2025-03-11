package com.example.content.controller;

import com.example.content.model.ContentItem;
import com.example.content.service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contents")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public ResponseEntity<List<ContentItem>> getAllContentItems() {
        return ResponseEntity.ok(contentService.getAllContentItems());
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<Map<String, Object>> getContentByEventId(@PathVariable String eventId) {
        Optional<ContentItem> contentOpt = contentService.getContentItemByEventId(eventId);
        if (contentOpt.isPresent()) {
            ContentItem item = contentOpt.get();
            Map<String, Object> response = new HashMap<>();
            response.put("seatingPlan", item.getSeatingPlan());
            response.put("multimedia", item.getMultimedia());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }   
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentItem> getContentItemById(@PathVariable String id) {
        return contentService.getContentItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContentItem> createContentItem(@RequestBody ContentItem contentItem) {
        ContentItem createdItem = contentService.createContentItem(contentItem);
        return ResponseEntity.ok(createdItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentItem> updateContentItem(@PathVariable String id,
                                                         @RequestBody ContentItem contentItem) {
        try {
            ContentItem updatedItem = contentService.updateContentItem(id, contentItem);
            return ResponseEntity.ok(updatedItem);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContentItem(@PathVariable String id) {
        contentService.deleteContentItem(id);
        return ResponseEntity.ok().build();
    }
}
