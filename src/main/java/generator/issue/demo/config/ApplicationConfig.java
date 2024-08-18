package generator.issue.demo.config;

import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "demo")
public class ApplicationConfig {

    @NotNull
    private String url;
    @NotNull
    private String username;
    @NotNull
    private String password;

    @PostConstruct
    public void logConfig() {
        log.info("Using url: {}", getUrl());
        log.info("Using username: {}", getUsername());
        log.info("Using password: {}", getPassword());
    }
}
