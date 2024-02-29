package com.dadry.techtask.entity;

import lombok.Data;

import java.util.List;

@Data
public class Report {
    private ReportSpecification reportSpecification;
    private List<DateReport> salesAndTrafficByDate;
    private List<AsinReport> salesAndTrafficByAsin;
}
