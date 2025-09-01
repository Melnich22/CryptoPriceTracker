package com.melnich.cryptopricetracker.prices;

import java.util.List;

public record PricesResponse(List<PriceDto> items) {}
