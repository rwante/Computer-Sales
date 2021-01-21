package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopDao extends JpaRepository<Laptop, Long> {
    Laptop findOneByProductCode(String productCode);
}
