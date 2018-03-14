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

        setData(note, resultMap);
        return resultMap;
    }

    @Override
    public ResultMap findByNewsIdAndUserId(Note note){
        ResultMap<Note> resultMap = new ResultMap();

        setData(note, resultMap);

        return resultMap;
    }

    private void setData(Note note, ResultMap<Note> resultMap) {
        try{
            resultMap.setData(noteMapper.selectByNewsIdAndUserId(note));
            resultMap.setCount(noteMapper.countByNewsIdAndUserId(note));
            resultMap.setSuccess(true);
        }catch (Exception e) {
            resultMap.setSuccess(false);
        }
    }

    @Override
    public boolean save(Note note){
        return noteMapper.insert(note) == 1;
    }

    @Override
    public boolean updateRecord(Note note) {
        return noteMapper.updateByPrimaryKeySelective(note) == 1;
    }
}
