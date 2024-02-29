package com.dadry.techtask.repository.impl;

import com.dadry.techtask.entity.AsinReport;
import com.dadry.techtask.entity.Sales;
import com.dadry.techtask.entity.Traffic;
import com.dadry.techtask.repository.AsinCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RequiredArgsConstructor
public class AsinCustomRepositoryImpl implements AsinCustomRepository {
    private final MongoOperations operations;

    @Override
    public AsinReport getSummaryReport() {
        TypedAggregation<AsinReport> pipeline = Aggregation.newAggregation(
                AsinReport.class,
                match(Criteria.where("parentAsin").ne(null)),
                getGroupOperation("salesByAsin.", "trafficByAsin."),
                getProjectOperation()
        );
        AggregationResults<Sales> sales = operations.aggregate(pipeline, Sales.class);
        AggregationResults<Traffic> traffic = operations.aggregate(pipeline, Traffic.class);
        AsinReport summaryReport = new AsinReport();
        summaryReport.setSalesByAsin(sales.getUniqueMappedResult());
        summaryReport.setTrafficByAsin(traffic.getUniqueMappedResult());
        return summaryReport;
    }
}
