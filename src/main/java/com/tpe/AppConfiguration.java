package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration //this will be my configuration class
@ComponentScan("com.tpe") //by defult it will scan all the paralel package
public class AppConfiguration {
}
