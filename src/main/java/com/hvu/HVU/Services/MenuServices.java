package com.hvu.HVU.Services;

import com.hvu.HVU.Repository.MenuRepository;
import com.hvu.HVU.Repository.WpTermsRepository;
import com.hvu.HVU.entity.WpTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServices {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private WpTermsRepository wpTermsRepository;

    public void addMenu(List<WpTerms> wps){
        wpTermsRepository.saveAll(wps);
    }
}
