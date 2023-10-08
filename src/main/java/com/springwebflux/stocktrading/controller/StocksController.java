package com.springwebflux.stocktrading.controller;


import java.math.BigDecimal;


import com.springwebflux.stocktrading.dto.StockRequest;
import com.springwebflux.stocktrading.dto.StockResponse;
import com.springwebflux.stocktrading.model.Stock;
import com.springwebflux.stocktrading.service.StocksService;
import lombok.AllArgsConstructor;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("/stocks")
public class StocksController {

    private StocksService stocksService;

    @GetMapping("/{id}")
    public Mono<StockResponse> getOneStock(@PathVariable String id) {
        return stocksService.getOneStock(id);
    }

    @GetMapping
    public Flux<StockResponse> getAllStocks(
        @RequestParam(required = false, defaultValue = "0") 
            BigDecimal priceGreaterThan) {
        return stocksService.getAllStocks(priceGreaterThan);
    }

    @PostMapping
    public Mono<StockResponse> createStock(@RequestBody StockRequest stock) {
        return stocksService.createStock(stock);
    }

}
