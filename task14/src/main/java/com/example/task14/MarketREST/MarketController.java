package com.example.task14.MarketREST;

import com.example.task14.MarketREST.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {
    private final MarketService marketService;
    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping()
    public String addNewMarket(@RequestBody Market market){
        marketService.add(market);
        return "Market: " + market.toString() + " was added";
    }

    @DeleteMapping("/{id}")
    public String deleteMarket(@PathVariable("id") Long id){
        if(marketService.delete(id)){
            return "Market was deleted";
        }
        else return "Such market didn`t exist";
    }
    @GetMapping
    public List<Market> getMarketList(){
        return marketService.getAll();

    }
}
