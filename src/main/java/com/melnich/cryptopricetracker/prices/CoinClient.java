package com.melnich.cryptopricetracker.prices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class CoinClient {
    private final RestClient http;
    private final String apiKey;

    CoinClient(RestClient http, @Value("${api.api-key:}") String apiKey) {
        this.http = http;
        this.apiKey = apiKey;
    }

    // GET /simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur
    Map<String, Map<String, BigDecimal>> simplePrice(List<String> coins, List<String> vs) {
        return http.get()
                .uri(uri -> uri.path("/simple/price")
                        .queryParam("ids", String.join(",", coins))
                        .queryParam("vs_currencies", String.join(",", vs))
                        .build())
                .headers(h -> { if (apiKey != null && !apiKey.isBlank()) h.add("x-cg-pro-api-key", apiKey); })
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}

