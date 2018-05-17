package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.Note;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @author ning on 18-4-5.
 * @project kdsn
 */
public interface NoteMapper {
    List<Note> selectByNewsIdAndUserId(Note record) throws DataAccessException;
    Integer insert(Note record) throws DataAccessException;
    List<Note> selectSelective(Note record) throws DataAccessException;
    Integer countByNewsIdAndUserId(Note record) throws DataAccessException;
    Integer updateByPrimaryKeySelective(Note record) throws DataAccessException;
}
