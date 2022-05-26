package com.example.task14.MarketREST;



import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MarketServiceImpl implements MarketService {
    private List<Market> marketList;

    public MarketServiceImpl() {
        this.marketList = new ArrayList<>();
    }

    @Override
    public void add(Market market) {
        marketList.add(market);
    }

    @Override
    public boolean delete(Long id) {
        return marketList.removeIf(x -> x.getId().equals(id));
    }

    @Override
    public List<Market> getAll() {
        return marketList;
    }
}
