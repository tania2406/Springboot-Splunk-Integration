package com.example.Springboot_Splunk_Integration.Service;

import com.example.Springboot_Splunk_Integration.Entity.Product;
import com.example.Springboot_Splunk_Integration.Repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    Logger logger = LogManager.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;
    public List<Product> findAll() {
        logger.info("we are starting the execution of findAll() in service ");
        List<Product> productsList = productRepository.findAll();

        logger.info("fetched the product list from db in service {} " +productsList);
        return productsList;
    }
    public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
}

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
