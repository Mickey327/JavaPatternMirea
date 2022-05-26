package ru.mirea.task15.Market;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MarketServiceTest {
    @Mock
    MarketRepository marketRepository;
    @Captor
    ArgumentCaptor<Market> marketArgumentCaptor;
    @Captor
    ArgumentCaptor<Long> idCaptor;

    @Test
    void getMarketById(){
        Market market = new Market();
        Long id = 1L;
        market.setId(id);
        market.setName("Magnit");
        Mockito.when(marketRepository.getById(id)).thenReturn(market);
        MarketService marketService = new MarketService(marketRepository);
        Assertions.assertEquals(market, marketService.getMarketById(id));
        Assertions.assertEquals("Magnit", marketService.getMarketById(id).getName());
    }
    @Test
    void getAllMarkets(){
        Market market1 = new Market();
        Market market2 = new Market();
        market1.setName("Magnit");
        market2.setName("Pyaterochka");
        Mockito.when(marketRepository.findAll()).thenReturn(List.of(market1,market2));
        MarketService marketService = new MarketService(marketRepository);
        Assertions.assertEquals(2, marketService.getAllUsingRepository().size());
        Assertions.assertEquals("Magnit", marketService.getAllUsingRepository().get(0).getName());

    }
    @Test
    void add(){
        Market market = new Market();
        market.setName("Magnit");
        MarketService marketService = new MarketService(marketRepository);
        marketService.add(market);
        Mockito.verify(marketRepository).save(marketArgumentCaptor.capture());
        Market capturedMarket = marketArgumentCaptor.getValue();
        Assertions.assertEquals(market, capturedMarket);
    }
    @Test
    void delete(){
        Market marketToDelete = new Market();
        Long id = 1L;
        marketToDelete.setId(id);
        marketToDelete.setName("Pyaterochka");
        MarketService marketService = new MarketService(marketRepository);
        marketService.delete(id);
        Mockito.verify(marketRepository).deleteById(idCaptor.capture());
        Long idToDelete = idCaptor.getValue();
        Assertions.assertEquals(marketToDelete.getId(), idToDelete);
    }


}
