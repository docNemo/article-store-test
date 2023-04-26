package ru.mai.articlestore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mai.articlestore.service.stub.StubService;

@Configuration
public class StubConfiguration {

    @Bean
    public StubService stubService() {
        return new StubService();
    }
}
