package com.example;

import com.example.controller.MdcPropagatingOnScheduleAction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rx.plugins.RxJavaHooks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SpringBootRxMoviesApplication {

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(6);
    }

    public static void main(String[] args) {
        // Set MDC
        RxJavaHooks.setOnScheduleAction(new MdcPropagatingOnScheduleAction());
        SpringApplication.run(SpringBootRxMoviesApplication.class, args);
    }
}
