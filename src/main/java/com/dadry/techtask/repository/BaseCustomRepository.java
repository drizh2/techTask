package com.dadry.techtask.repository;

import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

public interface BaseCustomRepository {
    List<String> SALES_FIELDS_LIST = Arrays.asList(
            "unitsOrdered", "unitsOrderedB2B", "totalOrderItems", "totalOrderItemsB2B",
            "averageUnitsPerOrderItem", "averageUnitsPerOrderItemB2B", "unitsRefunded", "refundRate",
            "claimsGranted", "unitsShipped", "ordersShipped"
    );

    List<String> SALES_BASE_SALES_FIELDS_LIST = Arrays.asList(
            "orderedProductSales", "orderedProductSalesB2B", "averageSalesPerOrderItem", "averageSalesPerOrderItemB2B",
            "averageSellingPrice", "averageSellingPriceB2B", "claimsAmount", "shippedProductSales"
    );

    List<String> TRAFFIC_FIELDS_LIST = Arrays.asList(
            "browserSessions", "browserSessionsB2B", "mobileAppSessions", "mobileAppSessionsB2B",
            "sessions", "sessionsB2B", "browserSessionPercentage", "browserSessionPercentageB2B",
            "mobileAppSessionPercentage", "mobileAppSessionPercentageB2B", "sessionPercentage", "sessionPercentageB2B",
            "browserPageViews", "browserPageViewsB2B", "mobileAppPageViews", "mobileAppPageViewsB2B",
            "pageViews", "pageViewsB2B", "browserPageViewsPercentage", "browserPageViewsPercentageB2B",
            "mobileAppPageViewsPercentage", "mobileAppPageViewsPercentageB2B", "pageViewsPercentage", "pageViewsPercentageB2B",
            "buyBoxPercentage", "buyBoxPercentageB2B", "unitSessionPercentage", "unitSessionPercentageB2B"
    );

    default GroupOperation getGroupOperation(String salesPrefix, String trafficPrefix) {
        GroupOperation groupOperation = group();
        for (String salesField : SALES_FIELDS_LIST) {
            groupOperation = groupOperation.sum(salesPrefix + salesField).as(salesField);
        }
        for (String salesField : SALES_BASE_SALES_FIELDS_LIST) {
            groupOperation = groupOperation.sum(salesPrefix + salesField + ".amount").as(salesField);
        }
        for (String trafficField : TRAFFIC_FIELDS_LIST) {
            groupOperation = groupOperation.sum(trafficPrefix + trafficField).as(trafficField);
        }
        return groupOperation;
    }

    default ProjectionOperation getProjectOperation() {
        List<String> projects = new ArrayList<>();
        projects.addAll(SALES_FIELDS_LIST);
        projects.addAll(SALES_BASE_SALES_FIELDS_LIST);
        projects.addAll(TRAFFIC_FIELDS_LIST);
        return project(projects.toArray(new String[]{}));
    }
}
