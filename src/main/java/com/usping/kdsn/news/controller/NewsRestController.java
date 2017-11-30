package com.usping.kdsn.news.controller;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.news.model.News;
import com.usping.kdsn.news.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(newsService.findAll(new PageRequest(10,10)), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/findForUser")
    public ResponseEntity<List> findNews(User user){
        return new ResponseEntity<>(newsService.findAll(new PageRequest(user.getPageNumber(),user.getPageSize())), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/news/{id}")
    public ResponseEntity<News> findNews(@PathVariable("id")String id){
        return new ResponseEntity<>(newsService.findNewsById(id), HttpStatus.OK);
    }
}
