package com.usping.kdsn.news.mapper;

import com.usping.kdsn.news.model.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, String> {
//    List<News> findAll(Pageable pageable);
    List<News> findAll();
}
