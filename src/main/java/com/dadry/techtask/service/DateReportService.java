package com.dadry.techtask.service;

import com.dadry.techtask.entity.DateReport;
import com.dadry.techtask.payload.request.DateReportRequest;
import com.dadry.techtask.repository.DateReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class DateReportService {

    private final DateReportRepository dateReportRepository;

    @Cacheable("dateReports")
    public List<DateReport> getDateReportsBetweenDates(DateReportRequest request) {
        if (Objects.isNull(request.getToDate())) {
            request.setToDate(request.getFromDate());
        }
        log.info("Getting date reports from {} to {}", request.getFromDate(), request.getToDate());

        LocalDate fromDate = request.getFromDate().minusDays(1);
        LocalDate toDate = request.getToDate().plusDays(1);

        return dateReportRepository.findDateReportByDateBetween(fromDate, toDate);
    }

    @Cacheable("dateSummaryReport")
    public DateReport getSummaryReport() {
        return dateReportRepository.getSummaryReport();
    }
}
