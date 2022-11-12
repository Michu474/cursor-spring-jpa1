package com.example.cursorspringjpa.service;

import com.example.cursorspringjpa.entity.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);

    Product update(Product product);

    Product updateQ(Product product, Long id);

    List<Product> getByExpireTime(int time);
    List<Product> getExpiredProducts();

    List<Product> getCheaperThan50();

    List<Product> getAllProducts();


}
