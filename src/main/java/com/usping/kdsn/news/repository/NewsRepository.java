package com.usping.kdsn.news.repository;

import com.usping.kdsn.news.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {
    Page<News> findAll(Pageable pageable);
    List<News> findAll();
    News findNewsById(String id);
}