package com.example.demomvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@SpringBootApplication
public class DemoMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMvcApplication.class, args);
    }


//    @Bean
//    LocaleResolver localeResolver() {
//        return new CookieLocaleResolver();
//    }
    @Bean
    CommandLineRunner runner(LocaleResolver localeResolver) {
        return (args) -> {
            System.out.println("AAA resolver=" + localeResolver.getClass());
        };
    }
}
