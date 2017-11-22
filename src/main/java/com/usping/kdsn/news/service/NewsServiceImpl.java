package com.usping.kdsn.news.service;

import com.usping.kdsn.news.model.News;
import com.usping.kdsn.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl implements NewsService{
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll(){
        return this.newsRepository.findAll();
    }

    @Override
    public List<News> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable).getContent();
    }

    @Override
    public News findNewsById(String id) {
        return newsRepository.findNewsById(id);
    }
}
