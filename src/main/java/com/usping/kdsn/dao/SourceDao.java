package com.usping.kdsn.dao;

import com.usping.kdsn.bean.Source;
import com.usping.kdsn.mapper.SourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SourceDao{

    private final SourceMapper sourceMapper;

    @Autowired
    public SourceDao(SourceMapper sourceMapper) {
        this.sourceMapper = sourceMapper;
    }

    public List<Source> selectByUser(Source source) {
        return sourceMapper.selectByUser(source);
    }

    public boolean insertSelective(Source source) throws DataAccessException {
        return sourceMapper.insertSelective(source);
    }

}
