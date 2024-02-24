package com.cst8277.messagingservice.client.config;

import com.cst8277.messagingservice.client.UserManagementClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean public WebClient userManagementWebClient(){
        return WebClient.builder()
                .baseUrl("http://user-management-service")
                .filter(filterFunction)
                .build();
    }
    @Bean
    public UserManagementClient userManagementClient() {
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(userManagementWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(UserManagementClient.class);
    }
}
