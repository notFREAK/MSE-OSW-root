package com.example.analytics.controller;

import com.example.analytics.model.Report;
import com.example.analytics.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // Эндпоинт для получения сводного отчёта
    @GetMapping("/report")
    public ResponseEntity<Report> getReport() {
        Report report = analyticsService.getAggregatedReport();
        return ResponseEntity.ok(report);
    }
}
