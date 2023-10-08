package com.springwebflux.stocktrading.service;


import java.math.BigDecimal;
import java.util.Optional;

import com.springwebflux.stocktrading.model.Stock;
import com.springwebflux.stocktrading.repository.StocksRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import com.pluralsight.springwebflux6.stocktrading.dto.StockRequest;
import com.pluralsight.springwebflux6.stocktrading.dto.StockResponse;




@Service
@Slf4j
@AllArgsConstructor
public class StocksService {

    private StocksRepository stocksRepository;

    public Optional<Stock> getOneStock(String id) {
        return stocksRepository.findById(id);
    }

    public Iterable<Stock> getAllStocks(BigDecimal priceGreaterThan) {
        return stocksRepository.findAll();
    }

    public Stock createStock(Stock stockRequest) {
        return stocksRepository.save(stockRequest);
    }
}
