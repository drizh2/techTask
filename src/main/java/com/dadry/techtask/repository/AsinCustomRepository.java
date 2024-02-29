package com.dadry.techtask.repository;

import com.dadry.techtask.entity.AsinReport;
import org.springframework.stereotype.Repository;

@Repository
public interface AsinCustomRepository extends BaseCustomRepository {
    AsinReport getSummaryReport();
}
