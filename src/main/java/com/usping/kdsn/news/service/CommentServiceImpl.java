package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Comment;
import com.usping.kdsn.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public boolean save(Comment comment) {
        return commentMapper.insert(comment) == 1;
    }

    @Override
    public Comment findByUserIdAndNewsId(int userId, String newsId) {
        return commentMapper.selectByUserIdAndNewsId(userId, newsId);
    }

    @Override
    public List<Comment> findByNewsId(String newsId){
        return commentMapper.selectByNewsId(newsId);
    }
}
