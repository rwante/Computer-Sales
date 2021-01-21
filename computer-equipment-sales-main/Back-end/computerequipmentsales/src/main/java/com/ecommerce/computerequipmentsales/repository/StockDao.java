package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
}
