package com.usping.kdsn.news.service;

import com.usping.kdsn.news.mapper.NewsRepository;
import com.usping.kdsn.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }
}
