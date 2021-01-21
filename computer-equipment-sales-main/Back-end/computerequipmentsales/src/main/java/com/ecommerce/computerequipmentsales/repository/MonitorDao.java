package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorDao extends JpaRepository<Monitor, Long> {
    Monitor findOneByProductCode(String productCode);
}
