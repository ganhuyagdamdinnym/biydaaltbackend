package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        System.out.println("Creating product and check price: " + product.getPrice());
        return productRepository.save(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        System.out.println("Total products: " + products.size());
        return products;
    }

}