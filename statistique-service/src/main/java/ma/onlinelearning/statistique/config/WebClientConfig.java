package ma.onlinelearning.statistique.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    // ✅ POUR MICROSERVICES (Eureka)
    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    // ✅ POUR APIS EXTERNES (YouTube, Google)
    @Bean
    public WebClient youtubeWebClient() {
        return WebClient.builder().build();
    }
}
