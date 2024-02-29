package com.dadry.techtask.repository;

import com.dadry.techtask.entity.DateReport;
import org.springframework.stereotype.Repository;

@Repository
public interface DateCustomRepository extends BaseCustomRepository {
    DateReport getSummaryReport();
}
