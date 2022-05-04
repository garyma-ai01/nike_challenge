package com.nike;


import com.opencsv.bean.CsvToBeanBuilder;
import com.nike.shoe.ShoeRepository;
import com.nike.shoe_adapter.ShoeEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
@Slf4j
public class App {

    @Autowired
    private ShoeRepository shoeRepository;

    @PostConstruct
    @SneakyThrows
    public void loadAndStore() {
        log.info("loading data from csv source and store into local db ::");

        List<ShoeEntity> sales = new CsvToBeanBuilder(new InputStreamReader(App.class.getClassLoader().getResourceAsStream("shoe.csv")))
                .withSkipLines(1)
                .withType(ShoeEntity.class)
                .build().parse();

        log.info(" saved {} records", shoeRepository.store(sales));

    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }
}
