package com.springwebflux.stocktrading.service;


import java.math.BigDecimal;

import com.springwebflux.stocktrading.dto.StockRequest;
import com.springwebflux.stocktrading.dto.StockResponse;
import com.springwebflux.stocktrading.repository.StocksRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;




@Service
@Slf4j
@AllArgsConstructor
public class StocksService {

    private StocksRepository stocksRepository;

    public Mono<StockResponse> getOneStock(String id) {
        return stocksRepository.findById(id)
                .map(StockResponse::fromModel);
    }

    public Flux<StockResponse> getAllStocks(BigDecimal priceGreaterThan) {
        return stocksRepository.findAll()
                .map(StockResponse::fromModel);
    }

    public Mono<StockResponse> createStock(StockRequest stockRequest) {
        return stocksRepository.save(stockRequest.toModel())
                .map(StockResponse::fromModel);
    }
}
