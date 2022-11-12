package com.example.cursorspringjpa.service.impl;

import com.example.cursorspringjpa.entity.Product;
import com.example.cursorspringjpa.exception.ProductNotFoundException;
import com.example.cursorspringjpa.repository.HibernateRepository;
import com.example.cursorspringjpa.repository.ProductRepository;
import com.example.cursorspringjpa.service.IProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {

    HibernateRepository hibernateRepository= new HibernateRepository();
    private final ProductRepository productRepository;

    public IProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {

        if(productRepository.existsById(id)){
        return productRepository.findProductById(id);
        }
        else {
            throw new ProductNotFoundException("User with id: "+id+" not found!");
        }
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }


    @Override
    @Transactional
    public Product updateQ(Product product, Long id) {
        System.out.println("Before Query"+product.toString());
         productRepository.updateProductsQ(product.getName(),product.getPrice(),product.getDescription(),product.getManufactureCountry(),
                product.getManufacturedYear(),product.getExpirationYear(),id);
        return product;
    }

    @Override
    public List<Product> getByExpireTime(int time) {
        LocalDate dateNow = LocalDate.now();
        int year = dateNow.getYear();
        return productRepository.getProductsByExpirationYearEquals(time+year);
    }

//    @Override
//    public List<Product> updateById(Product updatedProduct) {
//        return null;
//    }


    @Override
    public List<Product> getExpiredProducts() {
        LocalDate dateNow = LocalDate.now();
        int year = dateNow.getYear();
        return productRepository.getProductsByExpirationYearLessThan(year);
    }

    @Override
    public List<Product> getCheaperThan50() {
        double overPrice = 50;
        return productRepository.getProductsByPriceLessThan(overPrice);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }



}
