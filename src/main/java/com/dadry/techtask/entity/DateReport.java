package com.dadry.techtask.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DateReport {
    @Id
    private String id;
    private LocalDate date;
    private Sales salesByDate;
    private Traffic trafficByDate;
}
