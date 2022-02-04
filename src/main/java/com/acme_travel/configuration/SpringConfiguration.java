package com.acme_travel.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfiguration.class})
@ComponentScan(basePackages = {"com.acme_travel.flight"})
public class SpringConfiguration {

}
