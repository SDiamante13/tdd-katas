package tech.pathtoprogramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class AMoneyConverterShould {

    @Test
    void client() throws Exception {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("apikey", "DSnpC3Zn1zf1VduVixFYJLfFSM7lNWxP")
                .uri(new URI("https://api.apilayer.com/fixer/latest?symbols=USD,GBP&base=EUR"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assertions.assertThat(response.body()).isEqualTo(null);

    }
}
