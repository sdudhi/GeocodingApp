package com.geocoding.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author sdudhi
 *
 */
@Configuration
@ComponentScan("com.geocoding")
@EnableWebMvc
public class AppConfig {

}
