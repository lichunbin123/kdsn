package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.bean.Source;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SourceMapper {
    boolean insertSelective(Source source);
    List<Source> selectByUser(Source source);
}