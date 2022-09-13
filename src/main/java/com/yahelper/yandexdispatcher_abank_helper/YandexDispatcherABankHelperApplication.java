package com.yahelper.yandexdispatcher_abank_helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:project.properties")
public class YandexDispatcherABankHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(YandexDispatcherABankHelperApplication.class, args);
    }
}
