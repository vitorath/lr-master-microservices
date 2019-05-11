package course.udemy.limitsservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "limits-service")
public class Configuration {

    private int maximum;
    private int minimum;

}
