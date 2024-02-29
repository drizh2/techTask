package com.dadry.techtask.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DateReportRequest {
    @NotNull
    private LocalDate fromDate;
    private LocalDate toDate;
}
