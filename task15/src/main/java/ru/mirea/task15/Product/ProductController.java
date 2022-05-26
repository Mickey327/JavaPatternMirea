package ru.mirea.task15.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.Email.EmailService;
import ru.mirea.task15.Market.Market;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final EmailService emailService;

    @Autowired
    public ProductController(ProductService productService, EmailService emailService) {
        this.productService = productService;
        this.emailService = emailService;
    }

    @PostMapping("/{marketId}")
    public String addNewProduct(@RequestBody Product product, @PathVariable Long marketId){
        productService.add(product, marketId);
        emailService.sendSimpleEmail("usp0218@mail.ru","New product added",product.toString() + " was added");
        return "Market: " + product.toString() + " was added";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.delete(id);
        return "Product was deleted";
    }

    /*
    @GetMapping(value = "/{productId}/market")
    public Market getProductById(@PathVariable Long productId){
        return productService.getMarketByProduct(productId);
    }
    */
    @GetMapping
    public List<Product> getProductList(){
        return productService.getAllUsingRepository();

    }

    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable("price") Double price){
        return productService.getByPrice(price);
    }
    /*
    @GetMapping("/asc/{fieldName}")
    public List<Product> getListByFieldAscendingOrder(@PathVariable String fieldName){
        return productService.getListByFieldAscendingOrder(fieldName);
    }

     */

}
