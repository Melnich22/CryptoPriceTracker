package com.melnich.cryptopricetracker.prices;

import java.math.BigDecimal;
import java.util.List;

public record PriceDto(String coin, String currency, BigDecimal price, long fetchedAt) {}

