package com.example.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import com.example.demomvc.MyLocaleResolver;

/**
 * @author Tadaya Tsuyukubo
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
public class MyAutoConfiguration {

    @Configuration(proxyBeanMethods = false)
    static class MyWebConfiguration extends DelegatingWebMvcConfiguration {

        @Bean
        @Override
        @ConditionalOnMissingBean(name = DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME)
        public LocaleResolver localeResolver() {
            System.out.println("AAA creating MyLocaleResolver");
            return new MyLocaleResolver();
        }
    }

}
