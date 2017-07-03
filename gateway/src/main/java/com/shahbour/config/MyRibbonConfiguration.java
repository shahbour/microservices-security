package com.shahbour.config;

import exclude.MyDefaultRibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shahbour on 03/07/17.
 */
@Configuration
@RibbonClients(defaultConfiguration = MyDefaultRibbonConfiguration.class)
public class MyRibbonConfiguration {
}
