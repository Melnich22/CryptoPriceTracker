package com.melnich.cryptopricetracker.prices;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {

    private final CoinClient client;
    public PriceService(CoinClient client) { this.client = client; }

    @Cacheable(
            value  = "prices",
            key    = "T(java.lang.String).join(',', #coins) + '|' + T(java.lang.String).join(',', #vs)",
            //unless = "#result == null || #result.items().isEmpty()",
            sync   = true
    )
    public PricesResponse getPrices(List<String> coins, List<String> vs) {
        var map = client.simplePrice(coins, vs);  // externer Call nur bei Cache-Miss
        long ts = java.time.Instant.now().toEpochMilli();

        var items = new java.util.ArrayList<PriceDto>();
        map.forEach((coin, byFiat) -> byFiat.forEach((fiat, val) ->
                items.add(new PriceDto(coin, fiat, val, ts))));
        return new PricesResponse(items);
    }
}




