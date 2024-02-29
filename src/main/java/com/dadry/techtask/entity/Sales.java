package com.dadry.techtask.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sales {
    private BaseSale orderedProductSales;
    private BaseSale orderedProductSalesB2B;
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
    private BaseSale averageSalesPerOrderItem;
    private BaseSale averageSalesPerOrderItemB2B;
    private Double averageUnitsPerOrderItem;
    private Double averageUnitsPerOrderItemB2B;
    private BaseSale averageSellingPrice;
    private BaseSale averageSellingPriceB2B;
    private Integer unitsRefunded;
    private Double refundRate;
    private Integer claimsGranted;
    private BaseSale claimsAmount;
    private BaseSale shippedProductSales;
    private Integer unitsShipped;
    private Integer ordersShipped;
}
