package com.dadry.techtask.config;

import com.dadry.techtask.config.converter.NumberToBaseSaleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoConfiguration {
    @Bean
    public MongoCustomConversions mongoCustomConversions() {

        return new MongoCustomConversions(
                List.of(new NumberToBaseSaleConverter())
        );
    }
}
