package com.example.task14.ProductREST;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private List<Product> productList;

    public ProductServiceImpl() {
        this.productList = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public boolean delete(Long id) {
        return productList.removeIf(x -> x.getId().equals(id));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }
}
