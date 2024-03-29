package sfds.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    private String baseUri = "https://data.sfgov.org";

    @Bean("socrataRestTemplate")
    RestTemplate socrataRestTemplate(RestTemplateBuilder builder) {

        return builder
                .rootUri(baseUri)
                .build();

    }
}
