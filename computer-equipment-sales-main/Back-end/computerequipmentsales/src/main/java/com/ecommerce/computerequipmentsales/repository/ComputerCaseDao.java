package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.ComputerCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerCaseDao extends JpaRepository<ComputerCase, Long> {
    ComputerCase findOneByProductCode(String productCode);
}
