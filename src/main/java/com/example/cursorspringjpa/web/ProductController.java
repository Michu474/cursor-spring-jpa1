package com.example.cursorspringjpa.web;

import com.example.cursorspringjpa.entity.Product;
import com.example.cursorspringjpa.service.IProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fedorov_api/products/")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create")
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping(value = "/getById")
    public Product getProduct(@RequestParam Long id) {
        return productService.getProductById(id);
    }

    @GetMapping(value = "/getExpired")
    public List<Product> getExpired() {
        return productService.getExpiredProducts();
    }

    @GetMapping(value = "/getPriceLessThan")
    public List<Product> getPriceLessThan() {
        return productService.getCheaperThan50();
    }

    @GetMapping(value = "/getAll")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PatchMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }


    @GetMapping(value = "/expireTime")
    public List<Product> getByExpireTime(@RequestParam int time) {
        return productService.getByExpireTime(time);
    }

    @DeleteMapping(value = "/deleteProduct")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
    }

}
