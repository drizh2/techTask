package com.dadry.techtask.config.converter;

import com.dadry.techtask.entity.BaseSale;
import com.dadry.techtask.entity.enums.CurrencyCode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.NonNull;

@ReadingConverter
public class NumberToBaseSaleConverter implements Converter<Number, BaseSale> {
    @Override
    public BaseSale convert(@NonNull Number source) {
        return new BaseSale(source.doubleValue(), CurrencyCode.USD);
    }
}
