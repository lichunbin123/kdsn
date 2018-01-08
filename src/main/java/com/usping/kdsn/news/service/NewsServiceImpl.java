package com.usping.kdsn.news.service;

import com.usping.kdsn.news.model.News;
import com.usping.kdsn.news.repository.NewsRepository;
import com.usping.kdsn.news.repository.NewsTemplate;
import com.usping.kdsn.util.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class NewsServiceImpl implements NewsService{
    private final NewsRepository newsRepository;
    @Autowired
    private NewsTemplate newsTemplate;

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

    @Override
    public ResultMap findForUser(News news) {
        ResultMap resultMap = new ResultMap();

        resultMap.setData(newsRepository.findAll(new PageRequest(news.getPageNumber(),news.getPageSize())).getContent()).setTotal(newsRepository.countByUrlNotNull());

        return resultMap;
    }

    @Override
    public HashMap findDistinct() {
        return newsTemplate.findDistinct();
//        return newsRepository.findDistinctBySource("激光网");
    }
}
