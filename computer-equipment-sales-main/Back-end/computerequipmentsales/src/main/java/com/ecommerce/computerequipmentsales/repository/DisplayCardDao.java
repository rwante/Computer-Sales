package com.ecommerce.computerequipmentsales.repository;

import com.ecommerce.computerequipmentsales.entity.DisplayCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayCardDao extends JpaRepository<DisplayCard, Long> {
    DisplayCard findOneByProductCode(String productCode);
}
