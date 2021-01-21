package com.ecommerce.computerequipmentsales.repository.normalization;

import com.ecommerce.computerequipmentsales.entity.normalization.LaptopRAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRAMDao extends JpaRepository<LaptopRAM, Long> {
}
