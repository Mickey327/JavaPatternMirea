package com.example.task14.ProductREST;

import com.example.task14.ProductREST.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody Product product){
        productService.add(product);
        return "Product: " + product.toString() + " was added";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        if(productService.delete(id)){
            return "Product was deleted";
        }
        else return "Such product didn`t exist";
    }
    @GetMapping()
    public List<Product> getProductList(){
        return productService.getAll();

    }
}
