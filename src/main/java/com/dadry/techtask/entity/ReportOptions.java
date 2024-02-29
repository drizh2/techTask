package com.dadry.techtask.entity;

import com.dadry.techtask.entity.enums.AsinGranularity;
import com.dadry.techtask.entity.enums.DateGranularity;
import lombok.Data;

@Data
public class ReportOptions {
    private DateGranularity dateGranularity;
    private AsinGranularity asinGranularity;
}
