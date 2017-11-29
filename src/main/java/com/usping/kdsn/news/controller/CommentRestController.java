package com.usping.kdsn.news.controller;

import com.usping.kdsn.bean.Comment;
import com.usping.kdsn.news.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/comment")
public class CommentRestController {
    private static final Logger logger = Logger.getLogger(CommentRestController.class.getName());

    private final CommentServiceImpl commentService;

    @Autowired
    public CommentRestController(CommentServiceImpl newsService, CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @CrossOrigin
    @GetMapping("/comment")
    public ResponseEntity<List> findAll(Comment comment) {
        return null;
    }

    @CrossOrigin
    @GetMapping("/findByUserIdAndNewsId")
    public ResponseEntity<Comment> findByUserIdAndNewsId(String newsId, int userId) {
        Comment comment = commentService.findByUserIdAndNewsId(userId, newsId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/findByNewsId")
    public ResponseEntity<List<Comment>> findByNewsId(String newsId) {
        try {
            List<Comment> commentList = commentService.findByNewsId(newsId);
            if (commentList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(commentList, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @PostMapping("/comment")
    public ResponseEntity<?> add(@RequestBody Comment comment) {
        comment.setCommentDate(java.time.Instant.now().toEpochMilli());
        try {
            if (commentService.save(comment)) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
