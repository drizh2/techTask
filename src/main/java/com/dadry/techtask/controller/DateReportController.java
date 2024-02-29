package com.dadry.techtask.controller;

import com.dadry.techtask.entity.DateReport;
import com.dadry.techtask.payload.request.DateReportRequest;
import com.dadry.techtask.service.DateReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dateReport")
@RequiredArgsConstructor
public class DateReportController {

    private final DateReportService dateReportService;

    @GetMapping("/byDatesBetween")
    public ResponseEntity<List<DateReport>> getDateReportsByDatesBetween(@Valid @RequestBody DateReportRequest request) {
        List<DateReport> dateReports = dateReportService.getDateReportsBetweenDates(request);
        return new ResponseEntity<>(dateReports, HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<DateReport> getDateSummaryReport() {
        DateReport summaryReport = dateReportService.getSummaryReport();
        return new ResponseEntity<>(summaryReport, HttpStatus.OK);
    }
}
