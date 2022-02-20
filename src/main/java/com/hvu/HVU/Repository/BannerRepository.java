package com.hvu.HVU.Repository;

import com.hvu.HVU.entity.Banners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banners, Long> {
}
