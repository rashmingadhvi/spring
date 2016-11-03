package com.rmk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by RashMin on 29-10-2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.rmk.controller","com.rmk.dao","com.rmk.model","com.rmk.service"})
/**
 * This is a main configuration class for configuring the spring components
 */
public class ApplicationConfig {

}
