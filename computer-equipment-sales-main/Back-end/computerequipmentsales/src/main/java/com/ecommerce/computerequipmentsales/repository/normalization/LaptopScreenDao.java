package com.ecommerce.computerequipmentsales.repository.normalization;

import com.ecommerce.computerequipmentsales.entity.normalization.LaptopScreen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopScreenDao extends JpaRepository<LaptopScreen, Long> {
}
