package com.dadry.techtask.repository;

import com.dadry.techtask.entity.AsinReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsinReportRepository extends MongoRepository<AsinReport, String>, AsinCustomRepository {
    List<AsinReport> findAsinReportByParentAsinIgnoreCaseIn(List<String> parentAsinList);
}
