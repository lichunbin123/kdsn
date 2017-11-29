package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Comment;

import java.util.List;

interface CommentService {
    boolean save(Comment comment);

    Comment findByUserIdAndNewsId(int userId, String newsId);

    List<Comment> findByNewsId(String newsId);
}
