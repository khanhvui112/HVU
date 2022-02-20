package com.hvu.HVU.Repository;

import com.hvu.HVU.entity.WpTermTaxonomy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WpTermTaxonomyRepository extends JpaRepository<WpTermTaxonomy, Integer> {
}
