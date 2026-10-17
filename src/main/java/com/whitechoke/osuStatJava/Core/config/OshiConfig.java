package com.whitechoke.osuStatJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oshi.software.os.OperatingSystem;
import oshi.spi.SystemInfoFactory;
import oshi.spi.SystemInfoProvider;

@Configuration
public class OshiConfig {
    @Bean
    public OperatingSystem operatingSystem() {
        SystemInfoProvider si = SystemInfoFactory.create();
        return si.getOperatingSystem();
    }
}
