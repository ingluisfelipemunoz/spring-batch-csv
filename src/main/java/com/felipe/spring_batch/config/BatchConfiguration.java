package com.felipe.spring_batch.config;

import com.felipe.spring_batch.entity.Coffee;
import com.felipe.spring_batch.listeners.JobCompletionNotificationListener;
import com.felipe.spring_batch.processors.CoffeeItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
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
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {
    public static final String INSERT_SQL = "INSERT INTO coffee (brand, origin, characteristics) VALUES (:brand, :origin, :characteristics)";
    public static final String[] HEADER_NAMES = {"brand", "origin", "characteristics"};
    @Value("${file.input}")
    private String fileInput;
    private final String ITEM_READER_NAME = "coffeeItemReader";
    private final String STEP1_NAME = "step1";
    private final String IMPORT_USER_JOB_NAME = "importUserJob";



    @Bean
    public FlatFileItemReader reader() {
        return new FlatFileItemReaderBuilder().name(ITEM_READER_NAME)
                .resource(new ClassPathResource(fileInput))
                .delimited()
                .names(HEADER_NAMES)
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
                .sql(INSERT_SQL)
                .dataSource(datasource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder(IMPORT_USER_JOB_NAME, jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      JdbcBatchItemWriter writer) {
        return new StepBuilder(STEP1_NAME, jobRepository)
                .<Coffee, Coffee> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();

    }


    @Bean
    public CoffeeItemProcessor processor() {
        return new CoffeeItemProcessor();
    }


}
