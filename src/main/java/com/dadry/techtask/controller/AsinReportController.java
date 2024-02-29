package com.dadry.techtask.controller;

import com.dadry.techtask.entity.AsinReport;
import com.dadry.techtask.payload.request.AsinReportRequest;
import com.dadry.techtask.service.AsinReportService;
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
@RequestMapping("/api/asinReport")
@RequiredArgsConstructor
public class AsinReportController {

    private final AsinReportService asinReportService;

    @GetMapping("/byParentAsins")
    public ResponseEntity<List<AsinReport>> getAsinReportsByParentAsins(@Valid @RequestBody AsinReportRequest request) {
        List<AsinReport> reports = asinReportService.getAsinReportsByParentAsins(request.getParentAsins());
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<AsinReport> getAsinSummaryReport() {
        AsinReport summaryReport = asinReportService.getSummaryReport();
        return new ResponseEntity<>(summaryReport, HttpStatus.OK);
    }
}
