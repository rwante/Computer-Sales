package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.SSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSDDao extends JpaRepository<SSD, Long> {
    SSD findOneByProductCode(String productCode);
}
