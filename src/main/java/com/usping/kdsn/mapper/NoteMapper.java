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
    /**
     * 通过新闻id与用户id进行查询，得到与此相关的新闻笔记。实际上应该只返回一条。
     * @param record 有参数的record
     * @return 返回查询记录
     * @throws DataAccessException springboot内置exception，抛出由上级处理
     */
    List<Note> selectByNewsIdAndUserId(Note record) throws DataAccessException;

    /**
     * 通过
     * @param record
     * @return
     * @throws DataAccessException
     */
    Integer insert(Note record) throws DataAccessException;
    List<Note> selectSelective(Note record) throws DataAccessException;
    Integer countByNewsIdAndUserId(Note record) throws DataAccessException;
    Integer updateByPrimaryKeySelective(Note record) throws DataAccessException;
}