package com.felipe.spring_batch.config;

import com.felipe.spring_batch.entity.Coffee;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {
    @Value("${file.input}")
    private String fileInput;
    private final String ITEM_READER_NAME = "coffeeItemReader";


    @Bean
    public FlatFileItemReader reader() {
        return new FlatFileItemReaderBuilder().name(ITEM_READER_NAME)
                .resource(new ClassPathResource(fileInput))
                .delimited()
                .names(new String[]{"brand", "origin", "characteristics"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper(){
                    {
                        setTargetType(Coffee.class);
                    }
                }).build();
    }

    @Bean
    public JdbcBatchItemWriter writer(DataSource datasource) {
        return new JdbcBatchItemWriterBuilder()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider())
                .sql("INSERT INTO coffee (brand, origin, characteristics) VALUES (:brand, :origin, :characteristics)")
                .dataSource(datasource)
                .build();
    }


}
