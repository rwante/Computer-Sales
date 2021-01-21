package com.ecommerce.computerequipmentsales.repository.normalization;

import com.ecommerce.computerequipmentsales.entity.normalization.LaptopGPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopGPUDao extends JpaRepository<LaptopGPU, Long> {
}
