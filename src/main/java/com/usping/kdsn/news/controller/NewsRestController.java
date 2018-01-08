package com.usping.kdsn.news.controller;

import com.sun.xml.internal.bind.v2.TODO;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.news.model.News;
import com.usping.kdsn.news.service.MenuServiceImpl;
import com.usping.kdsn.news.service.NewsServiceImpl;
import com.usping.kdsn.util.model.ResultMap;
import com.usping.kdsn.util.tool.MenuMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.inject.New;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsRestController {
    private final NewsServiceImpl newsService;

    @Autowired
    public NewsRestController(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @Autowired
    private MenuServiceImpl menuService;

    @CrossOrigin
    @GetMapping("/news")
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<>(newsService.findAll(new PageRequest(10, 10)), HttpStatus.OK);
    }

//    @CrossOrigin
//    @GetMapping("/findForUser")
//    public ResponseEntity<List> findNews(User user){
//        return new ResponseEntity<>(newsService.findAll(new PageRequest(user.getPageNumber(),user.getPageSize())), HttpStatus.OK);
//    }

    @CrossOrigin
    @GetMapping("/news/{id}")
    public ResponseEntity<News> findNews(@PathVariable("id") String id) {
        return new ResponseEntity<>(newsService.findNewsById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/findForUser")
    public ResponseEntity<ResultMap> findForUser(News news) {
        try {
            ResultMap resultMap;
            resultMap = newsService.findForUser(news);
            if (resultMap.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @GetMapping("/testDistinct")
    public ResponseEntity<HashMap> testDistinct() {
//        HashMap hashMap = newsService.findDistinct();

        System.out.println(menuService.createMenu(6));

        return new ResponseEntity<>(menuService.createMenu(6), HttpStatus.OK);
    }
}
