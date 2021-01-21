package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorDao extends JpaRepository<Processor, Long> {
    Processor findOneByProductCode(String productCode);
}
