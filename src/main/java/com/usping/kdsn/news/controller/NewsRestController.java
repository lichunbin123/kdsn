package com.usping.kdsn.news.controller;

import com.usping.kdsn.news.model.News;
import com.usping.kdsn.news.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsRestController {
    private final NewsServiceImpl newsService;

    @Autowired
    public NewsRestController(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @CrossOrigin
    @GetMapping("/news")
    public ResponseEntity<List> findAll(){
        return new ResponseEntity<>(newsService.findAll(), HttpStatus.OK);
    }
}
