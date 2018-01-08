package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Note;
import com.usping.kdsn.mapper.NoteMapper;
import com.usping.kdsn.util.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: stan
 * @date: 3/12/17
 * description:
 */
@Component
public class NoteServiceImpl implements NoteService {
    private final NoteMapper noteMapper;

    @Autowired
    public NoteServiceImpl(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @Override
    public ResultMap findNoteByNewsId(Note note){
        ResultMap resultMap = new ResultMap();

        resultMap.setData(noteMapper.selectNoteByNewsId(note)).setTotal(noteMapper.countNoteByNewsId(note));

        return resultMap;
    }

    @Override
    public ResultMap findByNewsIdAndUserId(Note note){
        ResultMap resultMap = new ResultMap();

        resultMap.setData(noteMapper.selectByNewsIdAndUserId(note)).setTotal(noteMapper.countByNewsIdAndUserId(note));

        return resultMap;
    }

    @Override
    public boolean save(Note note){
        return noteMapper.insert(note) == 1;
    }

}
