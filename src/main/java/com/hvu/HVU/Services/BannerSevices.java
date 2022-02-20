package com.hvu.HVU.Services;

import com.hvu.HVU.Repository.BannerRepository;
import com.hvu.HVU.entity.Banners;
import com.hvu.HVU.utils.DrawDataUtil;
import com.hvu.HVU.utils.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BannerSevices {

    @Autowired
    private BannerRepository bannerRepository;

    @Value("${app.file.location}")
    String fileLocation;

    @Autowired
    private FileLocalStorageService fileLocalStorageService;

    public void saveBanners(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements element = DrawDataUtil.buildElements(doc, "#banner_bottom > ul > li");


        Iterator itr = element.iterator();
        List<Banners> banners = new ArrayList<>();

        while (itr.hasNext()) {
            Element e = (Element) itr.next();

            Banners banner = new Banners();
            banner.setBaLink(FileUtil.saveImages(e.select("li > a > div > img")
                    .attr("src"),"banners"));
            banner.setBaName(e.select("li > a >div.mrgt10").text());
            banners.add(banner);
        }

        bannerRepository.saveAll(banners);
    }
}
