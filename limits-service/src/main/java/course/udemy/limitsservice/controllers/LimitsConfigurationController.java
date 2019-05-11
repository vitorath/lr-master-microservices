package course.udemy.limitsservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import course.udemy.limitsservice.models.LimitConfiguration;
import course.udemy.limitsservice.properties.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LimitsConfigurationController {

    private final Configuration configuration;

    @GetMapping(path = "/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping(path = "/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallback")
    public LimitConfiguration retrieveonfigurations() {
        throw new RuntimeException("Fault Tolerance Example");
    }

    public LimitConfiguration fallback() {
        return new LimitConfiguration(9, 99999);
    }


}
