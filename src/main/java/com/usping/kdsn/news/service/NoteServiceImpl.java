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
    public List<Note> findNoteByNewsId(Note note){
        return noteMapper.selectByNewsIdAndUserId(note);
    }


    @Override
    public List<Note> findByNewsIdAndUserId(Note note){
        return noteMapper.selectByNewsIdAndUserId(note);
    }

    @Override
    public List<Note> selectSelective(Note note) {
        return noteMapper.selectSelective(note);
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
