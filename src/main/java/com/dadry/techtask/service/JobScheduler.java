package com.dadry.techtask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JobScheduler {
    private final ImportService reportImportService;
    private final CacheService cacheService;


    @Scheduled(fixedDelay = 1*60*1000)
    public void importReport() {
        reportImportService.importReportData();
    }

    @Scheduled(fixedDelay = 1*60*1000)
    public void evictAllCache() {
        cacheService.eviceAllCache();
    }
}
