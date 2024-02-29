package com.dadry.techtask.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsinReport {
    @Id
    private String id;
    private String parentAsin;
    private Sales salesByAsin;
    private Traffic trafficByAsin;
}
