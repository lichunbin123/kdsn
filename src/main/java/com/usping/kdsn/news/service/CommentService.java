package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Comment;

import java.util.List;

interface CommentService {
    /**
     * save instance
     * @param comment
     * @return
     */
    boolean save(Comment comment);

    /**
     * findUser
     * todo- to fix with fulfillment method
     * @param userId
     * @param newsId
     * @return
     */
    Comment findByUserIdAndNewsId(int userId, String newsId);

    /**
     * findByNewsId
     * @param newsId
     * @return
     */
    List<Comment> findByNewsId(String newsId);
}
