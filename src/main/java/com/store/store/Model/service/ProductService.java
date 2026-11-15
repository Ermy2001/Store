package com.store.store.Model.service;

import com.store.store.Model.entity.Product;
import com.store.store.Model.repository.ProductRepository;
import java.util.List;

public class ProductService {

    public static void save (Product product) throws Exception {
        if (product.getPrice() == null || product.getPrice().signum() < 0) {
            throw new Exception("Price cannot be negative");
        }

        try (ProductRepository repository = new ProductRepository()) {
            repository.save(product);
        }
    }

    public static List<Product> findAll() throws Exception{
        try (ProductRepository repository = new ProductRepository()) {
            return repository.findAll();
        }
    }
}
