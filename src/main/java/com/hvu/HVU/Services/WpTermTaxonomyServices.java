package com.hvu.HVU.Services;

import com.hvu.HVU.Repository.WpTermTaxonomyRepository;
import com.hvu.HVU.entity.WpTermTaxonomy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WpTermTaxonomyServices {
    @Autowired
    private WpTermTaxonomyRepository wpTermTaxonomyRepository;
    public void insertTermTaxonomy(List<WpTermTaxonomy> wpts){
        wpTermTaxonomyRepository.saveAll(wpts);
    }
}
