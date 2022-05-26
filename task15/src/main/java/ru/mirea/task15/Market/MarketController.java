package ru.mirea.task15.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.Email.EmailService;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {
    private final MarketService marketService;
    private final EmailService emailService;

    @Autowired
    public MarketController(MarketService marketService, EmailService emailService) {
        this.marketService = marketService;
        this.emailService = emailService;
    }


    @PostMapping()
    public String addNewMarket(@RequestBody Market market){
        marketService.add(market);
        emailService.sendSimpleEmail("usp0218@mail.ru","New market added",market.toString() + " was added");
        return "Market: " + market.toString() + " was added";
    }

    @DeleteMapping("/{id}")
    public String deleteMarket(@PathVariable("id") Long id){
        marketService.delete(id);
        return "Market was deleted";
    }

    @GetMapping
    public List<Market> getMarketList(){
        return marketService.getAllUsingRepository();

    }
/*
    @GetMapping("/asc/{fieldName}")
    public List<Market> getListByFieldAscendingOrder(@PathVariable String fieldName){
        return marketService.getListByFieldAscendingOrder(fieldName);
    }
    */

}
