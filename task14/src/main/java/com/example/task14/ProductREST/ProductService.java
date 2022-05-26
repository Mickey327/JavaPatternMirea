package com.example.task14.ProductREST;

import com.example.task14.MarketREST.Market;

import java.util.List;

public interface ProductService {
    void add(Product product);
    boolean delete(Long id);
    List<Product> getAll();
}
