package com.ecommerce.computerequipmentsales.repository.normalization;

import com.ecommerce.computerequipmentsales.entity.normalization.MainboardRAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainboardRAMDao extends JpaRepository<MainboardRAM, Long> {
}
