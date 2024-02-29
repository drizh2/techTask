package com.dadry.techtask.entity;

import com.dadry.techtask.entity.enums.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseSale {
    private Double amount;
    private CurrencyCode currencyCode;
}
