package generator.issue.demo.config;

import generator.issue.demo.api.ApiClient;
import generator.issue.demo.api.another_external_resources.AnotherResourceApi;
import generator.issue.demo.api.external_resources.SomeResourceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RestServicesConfig {

    private final ApplicationConfig config;

    @Bean
    public SomeResourceApi getResourceApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(config.getUrl());
        apiClient.setUsername(config.getUsername());
        apiClient.setPassword(config.getPassword());
        return new SomeResourceApi(apiClient);
    }

    @Bean
    public AnotherResourceApi getAnotherResourceApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(config.getUrl());
        return new AnotherResourceApi(apiClient);
    }
}
