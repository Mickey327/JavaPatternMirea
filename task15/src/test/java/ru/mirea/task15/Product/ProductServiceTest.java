package ru.mirea.task15.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task15.Market.Market;
import ru.mirea.task15.Market.MarketRepository;
import ru.mirea.task15.Market.MarketService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    @Mock
    MarketRepository marketRepository;
    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;
    @Captor
    ArgumentCaptor<Long> idCaptor;

    @Test
    void getAll(){
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setName("Beer");
        product2.setName("Vodka");
        Mockito.when(productRepository.findAll()).thenReturn(List.of(product1, product2));
        ProductService productService = new ProductService(productRepository, marketRepository);
        Assertions.assertEquals(2, productService.getAllUsingRepository().size());
        Assertions.assertEquals("Vodka", productService.getAllUsingRepository().get(1).getName());

    }

    @Test
    void add(){
        Product product = new Product();
        Long marketId = 1L;
        product.setName("Beer");
        ProductService productService = new ProductService(productRepository, marketRepository);
        productService.add(product,marketId);
        Mockito.verify(productRepository).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();
        Assertions.assertEquals(product, capturedProduct);
    }

    @Test
    void delete(){
        Product productToDelete = new Product();
        Long id = 1L;
        productToDelete.setId(id);
        productToDelete.setName("Beer");
        ProductService productService = new ProductService(productRepository, marketRepository);
        productService.delete(id);
        Mockito.verify(productRepository).deleteById(idCaptor.capture());
        Long idToDelete = idCaptor.getValue();
        Assertions.assertEquals(productToDelete.getId(), idToDelete);
    }

}
