package com.hvu.HVU.Repository;

import com.hvu.HVU.entity.WpTerms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface WpTermsRepository extends JpaRepository<WpTerms, Integer> {
}
