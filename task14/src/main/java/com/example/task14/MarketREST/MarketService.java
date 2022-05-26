package com.example.task14.MarketREST;

import org.springframework.stereotype.Service;

import java.util.List;


public interface MarketService {
    void add(Market market);
    boolean delete(Long id);
    List<Market> getAll();
}
