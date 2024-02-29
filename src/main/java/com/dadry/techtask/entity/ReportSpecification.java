package com.dadry.techtask.entity;

import com.dadry.techtask.entity.enums.ReportType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReportSpecification {
    private ReportType reportType;
    private ReportOptions reportOptions;
    private LocalDate dataStartTime;
    private LocalDate dataEndTime;
    private List<String> marketplaceIds;
}
