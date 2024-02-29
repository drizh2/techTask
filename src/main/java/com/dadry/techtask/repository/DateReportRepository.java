package com.dadry.techtask.repository;

import com.dadry.techtask.entity.DateReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DateReportRepository extends MongoRepository<DateReport, String>, DateCustomRepository {
    List<DateReport> findDateReportByDateBetween(LocalDate fromDate, LocalDate toDate);
}
