package com.usping.kdsn.news.service;

import com.usping.kdsn.news.model.News;
import com.usping.kdsn.util.model.ResultMap;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;

public interface NewsService {
    public List<News> findAll();
    public List<News> findAll(Pageable pageable);
    public News findNewsById(String id);

    ResultMap findForUser(News news);

    HashMap findDistinct();

}
