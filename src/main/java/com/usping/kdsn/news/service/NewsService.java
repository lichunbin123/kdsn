package com.usping.kdsn.news.service;

import com.usping.kdsn.news.model.News;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    public List<News> findAll();
    public List<News> findAll(Pageable pageable);
    public News findNewsById(String id);
}
