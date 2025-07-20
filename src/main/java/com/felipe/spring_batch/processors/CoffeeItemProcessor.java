package com.felipe.spring_batch.processors;

import com.felipe.spring_batch.entity.Coffee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CoffeeItemProcessor implements ItemProcessor<Coffee, Coffee> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeItemProcessor.class);

    @Override
    public Coffee process(final Coffee item) throws Exception {
        String brand = item.getBrand().toUpperCase();
        String origin = item.getOrigin().toUpperCase();
        String characteristics = item.getCharacteristics().toUpperCase();

        Coffee transformedCoffee = new Coffee(brand, origin, characteristics);
        LOGGER.info("Converting ( {} ) into ( {} )", item, transformedCoffee);

        return transformedCoffee;
    }
}
