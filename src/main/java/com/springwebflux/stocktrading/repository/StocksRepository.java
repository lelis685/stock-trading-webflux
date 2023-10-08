package com.springwebflux.stocktrading.repository;

import com.springwebflux.stocktrading.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StocksRepository extends MongoRepository<Stock, String> {
}
