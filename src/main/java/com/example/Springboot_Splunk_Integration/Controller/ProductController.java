package com.example.Springboot_Splunk_Integration.Controller;


import com.example.Springboot_Splunk_Integration.Entity.Product;
import com.example.Springboot_Splunk_Integration.Repository.ProductRepository;
import com.example.Springboot_Splunk_Integration.Service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController
{
Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    ProductService productService;
    @GetMapping("/test")
    public String test()
    {
        return "test for splunk integration";
    }
    @GetMapping("/all")
    public List<Product> findAll()
    {
        logger.info("started hitting the findAll api from controller");
        List<Product> productList = productService.findAll();
        logger.info("fetched all products from service in controller" +productList);
        return productList;

    }
    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product,@PathVariable long id) {
        Product p=productService.findById(id).get();
        p.setName(product.getName());
        p.setPrice(p.getPrice());
        p.setQuantity(product.getQuantity());
        return productService.save(p);
    }

    @DeleteMapping("/del/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
