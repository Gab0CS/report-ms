package com.gabo.report_ms.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabo.report_ms.services.ReportService;

import lombok.AllArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "report")
@AllArgsConstructor
public class ReportController {
    private ReportService reportService;

    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String, String>> getReport(@PathVariable String name) {
        var response = Map.of("report", this.reportService.makeReport(name));

        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<String> postReport(@RequestBody String report){
        return ResponseEntity.ok(this.reportService.saveReport(report));
    }    

    @DeleteMapping(path = "{name}")
    public ResponseEntity<Void> deleteReport(@PathVariable String name){
        this.reportService.deleteReport(name);
        return ResponseEntity.noContent().build();
    }
}
