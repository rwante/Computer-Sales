package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.Mainboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainboardDao extends JpaRepository<Mainboard, Long> {
    Mainboard findOneByProductCode(String productCode);
}
