package com.usping.kdsn.news.controller;

import com.usping.kdsn.bean.Note;
import com.usping.kdsn.news.service.NoteServiceImpl;
import com.usping.kdsn.util.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: stan
 * @date: 3/12/17
 * description:
 */
@RestController
@RequestMapping("/api/note")
public class NoteRestController {
    private final NoteServiceImpl noteService;

    @Autowired
    public NoteRestController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    /**
     * 查询当前用户在新闻下的笔记
     * @param note
     * @return
     */
    @CrossOrigin
    @GetMapping("/findByNewsIdAndUserId")
    public ResponseEntity<ResultMap> findByNewsIdAndUserId(Note note) {
        try {
            ResultMap resultMap;
            resultMap = noteService.findByNewsIdAndUserId(note);
            if (resultMap.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(resultMap, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @GetMapping("/findByUserId")
    public ResponseEntity<ResultMap> findByUserId(Note note) {

        return null;
    }

    @CrossOrigin
    @PostMapping("/note")
    public ResponseEntity<?> add(@RequestBody Note note) {
        note.setNoteDate((int) java.time.Instant.now().toEpochMilli());
        try {
            if (noteService.save(note)) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
