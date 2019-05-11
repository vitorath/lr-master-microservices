package course.udemy.currencyexchangeservice.controllers;

import course.udemy.currencyexchangeservice.models.ExchangeValue;
import course.udemy.currencyexchangeservice.repositories.ExchangeValueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        exchangeValue.setPort(port);
        log.info("{}", exchangeValue);
        return exchangeValue;
    }

}
