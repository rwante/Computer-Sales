package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.HDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDDao extends JpaRepository<HDD, Long> {
    HDD findOneByProductCode(String productCode);
}
