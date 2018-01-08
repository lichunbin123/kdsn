package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Note;
import com.usping.kdsn.util.model.ResultMap;

import java.util.List;

/**
 * @author: stan
 * @date: 3/12/17
 * description:
 */
public interface NoteService {
    ResultMap findNoteByNewsId(Note note);

    ResultMap findByNewsIdAndUserId(Note note);

    boolean save(Note note);
}
