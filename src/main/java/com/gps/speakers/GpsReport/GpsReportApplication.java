package com.gps.speakers.GpsReport;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan({"com.gps.speakers.GpsReport.controller","com.gps.speakers.GpsReport.dao","com.gps.speakers.GpsReport.service","com.gps.speakers.GpsReport"})
@SpringBootApplication
public class GpsReportApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GpsReportApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(GpsReportApplication.class, args);
	}

}
