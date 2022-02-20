package com.hvu.HVU.controller;

import com.hvu.HVU.Services.*;
import com.hvu.HVU.entity.*;
import com.hvu.HVU.utils.DrawDataUtil;
import com.hvu.HVU.utils.FileUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuServices menuServices;

    @Autowired
    private PostsSevices postsSevices;

    @Autowired
    private DepartmentsSevices departmentsSevices;

    @Autowired
    private BannerSevices bannerSevices;

    @Autowired
    private WpTermTaxonomyServices wpTermTaxonomyServices;

    private static final String REMOVE = "https://www.hvu.edu.vn";


    @GetMapping("/")
    private String addMenu() {

        return "menu";
    }
    @GetMapping("/menus")
    public String addMenus() throws IOException {
        Document  doc =  DrawDataUtil.buildDoc("https://www.hvu.edu.vn/");

        Elements element = DrawDataUtil.buildElements(doc,".navbar-nav li");
        Iterator itr = DrawDataUtil.buildIterators(element);

        List<WpTerms> wps = new ArrayList<>();
        List<WpTermTaxonomy> wpts = new ArrayList<>();

        int count = 8;
        int temId = 9;
        int index = 8;

        while (itr.hasNext()) {
            Element e = (Element) itr.next();
            WpTerms wp = new WpTerms();
            WpTermTaxonomy wpt = new WpTermTaxonomy();
            wpt.setTermId(temId);
            wpt.setTaxonomy("category");
            wpt.setCount(0);
            wpt.setDescription("");
            System.out.println("String re: "+ (e.select("a").attr("href").replaceAll(REMOVE,"")));
            wp.setSlug((e.select("a").attr("href").replaceAll(REMOVE,"")));
            wp.setName(e.select("a").attr("title"));
            wp.setTermGroup(Integer.valueOf(0));

//            neeus viet thuong thi la con
            if(!DrawDataUtil.isStringUpperCase(wp.getName())){
                wpt.setParent(count);
                count--;
//          nguoc lai. set count = index;
            }else {
                count = index;
                wpt.setParent(0);
            }

            wps.add(wp);
            wpts.add(wpt);
            index++;
            count++;
            temId++;
        }

//        end draw data
        menuServices.addMenu(wps);
        wpTermTaxonomyServices.insertTermTaxonomy(wpts);
        return "menu";
    }

    @GetMapping("/departments")
    private String addDepartments() throws IOException {
        //        start craw data post
        crawDataDepartments("https://www.hvu.edu.vn/", "1");
        return "menu";
    }



    @GetMapping("/banners")
    public String addBanners() throws IOException {
        bannerSevices.saveBanners("https://www.hvu.edu.vn/");
        return "menu";
    }

    @GetMapping("/posts")
    public String addPosts() throws IOException {

        //        add data posts 1
        List<String> posts = new ArrayList<>();
        posts = DrawDataUtil.loopDataDraw(posts,102, "https://www.hvu.edu.vn/tin-tuc/tin-tuc-chung/trang-");

        //        build link data posts 2
        posts = DrawDataUtil.loopDataDraw(posts,26, "https://www.hvu.edu.vn/tin-tuc/hoi-thao-hoi-nghi/trang-");

        posts = DrawDataUtil.loopDataDraw(posts,7, "https://www.hvu.edu.vn/tin-tuc/thong-bao/trang-");

        for (String s : posts) {
            crawDataPost(s);
        }

        return "menu";
    }

    //    craw data posts
    public void crawDataPost(String url) throws IOException {

        Document doc = DrawDataUtil.buildDoc(url);
        Elements element = doc.select("#outline .news-cat");
        Iterator itr = element.iterator();
        List<Posts> posts = new ArrayList<>();

        while (itr.hasNext()) {
            Element e = (Element) itr.next();
            Posts post = new Posts();
            post.setImage(FileUtil.saveImages(e.select("p >a >img").attr("src"),"posts"));
            post.setTitle(e.select("a.link-title b").text());
            post.setDescription(e.select("p").not("a").text());
            posts.add(post);
        }

        postsSevices.addPosts(posts);
    }

    //    craw data posts
    public void crawDataDepartments(String url, String numberTab) throws IOException {

        Document doc = DrawDataUtil.buildDoc(url);

        url = "#tabs-"+numberTab + " > p";
        Elements element = doc.select(url);
        Iterator itr = element.iterator();
        List<Departments> departments = new ArrayList<>();

        while (itr.hasNext()) {
            Element e = (Element) itr.next();
            Departments department = new Departments();
            department.setIcon(e.select("p > i").attr("class"));
            department.setDepName(e.select("p >a").text());
            department.setLink(e.select("p > a").attr("href"));
            departments.add(department);
        }

        departmentsSevices.addDepartments(departments);
    }

}
