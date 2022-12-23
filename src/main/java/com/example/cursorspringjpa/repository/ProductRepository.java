package com.example.cursorspringjpa.repository;

import com.example.cursorspringjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Long id);

    List<Product> getProductsByExpirationYearLessThan(int year);

    List<Product> getProductsByPriceLessThan(double price);

    List<Product> getProductsByExpirationYearEquals(int time);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.name=:name,p.price=:price,p.description=:description,p.manufactureCountry=:manufactureCountry,p.manufacturedYear=:manufacturedYear,p.expirationYear=:expirationYear WHERE p.id = :id")
    void updateProductsQ(String name, double price, String description, String manufactureCountry,
                         int manufacturedYear, int expirationYear, Long id);


}
