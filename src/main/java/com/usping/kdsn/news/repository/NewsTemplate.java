package com.usping.kdsn.news.repository;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author: stan
 * @date: 4/12/17
 * description:
 */
@Repository
public class NewsTemplate {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public NewsTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public HashMap findDistinct() {
        HashMap<String,List<String>> hashMap = new HashMap();

        List<String> stringList = mongoTemplate.getCollection("news").distinct("type");
        for (String e : stringList) {
            Query query = new Query();
            query.addCriteria(Criteria.where("type").is(e));
            List list = mongoTemplate.getCollection("news").distinct("source", query.getQueryObject());
            hashMap.put(e, list);
        }
        return hashMap;
    }
}
