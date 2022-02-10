package xyz.zerxoi.covemidiff.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class EMIConfig {
    @Value("${emi.parent-location}")
    private String parentLocation;
}
