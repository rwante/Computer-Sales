package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMDao extends JpaRepository<RAM, Long> {
    RAM findOneByProductCode(String productCode);
}
