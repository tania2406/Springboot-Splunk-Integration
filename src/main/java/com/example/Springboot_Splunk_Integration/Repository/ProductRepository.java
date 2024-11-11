package com.example.Springboot_Splunk_Integration.Repository;

import com.example.Springboot_Splunk_Integration.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
