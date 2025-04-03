package com.gabo.report_ms.beans;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context){
        log.info("Configurando load balancer");
        return ServiceInstanceListSupplier
            .builder()
            .withBlockingDiscoveryClient()
            .withSameInstancePreference()
            .build(context);
    }  
}
