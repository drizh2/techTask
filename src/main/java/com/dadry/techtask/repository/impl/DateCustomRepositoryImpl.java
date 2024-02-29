package com.dadry.techtask.repository.impl;

import com.dadry.techtask.entity.DateReport;
import com.dadry.techtask.entity.Sales;
import com.dadry.techtask.entity.Traffic;
import com.dadry.techtask.repository.DateCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;

@RequiredArgsConstructor
public class DateCustomRepositoryImpl implements DateCustomRepository {
    private final MongoOperations operations;

    @Override
    public DateReport getSummaryReport() {
        TypedAggregation<DateReport> pipeline = Aggregation.newAggregation(
                DateReport.class,
                match(Criteria.where("date").ne(null)),
                getGroupOperation("salesByDate.", "trafficByDate."),
                getProjectOperation()
        );

        AggregationResults<Sales> sales = operations.aggregate(pipeline, Sales.class);
        AggregationResults<Traffic> traffic = operations.aggregate(pipeline, Traffic.class);
        DateReport summaryReport = new DateReport();
        summaryReport.setSalesByDate(sales.getUniqueMappedResult());
        summaryReport.setTrafficByDate(traffic.getUniqueMappedResult());
        return summaryReport;
    }
}
