package am.gitc.api;

import am.gitc.api.rest.UserEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "am.gitc.backend.common.repository")
@EntityScan(basePackages = "am.gitc.backend.common.model")
@ComponentScan(basePackages = {"am.gitc.api.*", "am.gitc.backend.common.*"})
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
