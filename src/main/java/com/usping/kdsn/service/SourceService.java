package com.usping.kdsn.service;

import com.usping.kdsn.bean.Source;
import com.usping.kdsn.util.model.ResponseMessage;

public interface SourceService {
    public ResponseMessage<Source> insert(Source source);
}
