package com.usping.kdsn.news.controller;

import com.usping.kdsn.bean.Note;
import com.usping.kdsn.news.service.NoteServiceImpl;
import com.usping.kdsn.util.model.ResultMap;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author: stan
 * @date: 3/12/17
 * description:
 */
@RestController
@RequestMapping("/api/note")
public class NoteRestController {

    private Logger logger = LoggerFactory.getLogger(NoteRestController.class);

    private NoteServiceImpl noteService;

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
    public ResponseEntity<ResultMap> findByNewsIdAndUserId( Note note) {
//        try {
//            ResultMap resultMap;
//            return new ResponseEntity<>(resultMap, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        List<Note> noteList = noteService.findByNewsIdAndUserId(note);

        ResultMap resultMap = new ResultMap();
        resultMap = resultMap.builder().success(new Boolean(true)).empty(false).build();

        return new ResponseEntity<>(resultMap, HttpStatus.OK);


        // TODO: 18-4-9 将返回修改为Result
//        return null;
    }

    @CrossOrigin
    @GetMapping("/findByUserId")
    public ResponseEntity<ResultMap> findByUserId(Note note) {

        return null;
    }

    @CrossOrigin
    @PostMapping("/note")
    public ResponseEntity<?> add(@RequestBody Note note) {
        logger.info(note.toString());
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

    @CrossOrigin
    @PostMapping("/makePublic")
    public ResponseEntity<Map<String,Boolean>> makePublic(@RequestBody Note note) {
        WeakHashMap<String,Boolean> resultMap = new WeakHashMap<>();
        note.setPublicState(1);
        try {
            resultMap.put("success", true);
            noteService.updateRecord(note);
            return new ResponseEntity<Map<String, Boolean>>(resultMap,HttpStatus.OK);
        } catch (Exception e){
            resultMap.put("success", false);
            return new ResponseEntity<Map<String, Boolean>>(resultMap ,HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
