package tech.pathtoprogramming;

import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchangeBoard implements ExchangeBoard {

    private final HttpClient client;

    public CurrencyExchangeBoard() {
        this.client = HttpClient.newHttpClient();
    }

    @Override
    public BigDecimal getExchangeRateFor(Money baseMoney, Currency targetCurrency) {
        try {
            URI uri = new URI("https://api.apilayer.com/fixer/latest?symbols=" + targetCurrency.name() + "&base=" + baseMoney.currency().name());
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .header("apikey", System.getenv("apiKey"))
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            RatesDTO ratesDTO = new Gson().fromJson(response.body(), RatesDTO.class);
            return ratesDTO.exchangeRate(targetCurrency);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

