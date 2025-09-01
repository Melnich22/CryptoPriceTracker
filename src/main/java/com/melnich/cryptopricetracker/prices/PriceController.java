package com.melnich.cryptopricetracker.prices;

import com.melnich.cryptopricetracker.prices.PriceService;
import com.melnich.cryptopricetracker.prices.PricesResponse;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
@Validated
public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    @GetMapping
    public PricesResponse prices(
            @RequestParam @NotBlank String coins,
            @RequestParam(defaultValue = "usd") String vs) {

        List<String> coinList = Arrays.stream(coins.split(","))
                .map(String::trim).filter(s -> !s.isEmpty()).sorted().toList();

        List<String> vsList = Arrays.stream(vs.split(","))
                .map(String::trim).filter(s -> !s.isEmpty()).sorted().toList();

        return service.getPrices(coinList, vsList);

    }
}

