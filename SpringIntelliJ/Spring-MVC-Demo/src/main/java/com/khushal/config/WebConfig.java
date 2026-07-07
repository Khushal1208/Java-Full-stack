package com.khushal.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@ComponentScan(basePackages = "com.khushal")
@EnableWebMvc
public class WebConfig {

}
