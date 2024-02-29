package com.dadry.techtask.service;

import com.dadry.techtask.entity.AsinReport;
import com.dadry.techtask.repository.AsinReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AsinReportService {

    private final AsinReportRepository asinReportRepository;

    @Cacheable("asinReports")
    public List<AsinReport> getAsinReportsByParentAsins(List<String> parentAsins) {
        log.info("Getting asin reports for {}", parentAsins);
        return asinReportRepository.findAsinReportByParentAsinIgnoreCaseIn(parentAsins);
    }

    @Cacheable("asinSummaryReport")
    public AsinReport getSummaryReport() {
        return asinReportRepository.getSummaryReport();
    }

}
