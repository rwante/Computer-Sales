package com.ecommerce.computerequipmentsales.repository.normalization;

import com.ecommerce.computerequipmentsales.entity.normalization.LaptopHDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopHDDDao extends JpaRepository<LaptopHDD, Long> {
}
