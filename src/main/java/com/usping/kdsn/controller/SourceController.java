package com.usping.kdsn.controller;

import com.usping.kdsn.bean.Source;
import com.usping.kdsn.service.SourceService;
import com.usping.kdsn.util.model.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/source")
public class SourceController {

    private final Logger logger = LoggerFactory.getLogger(SourceController.class);

    private final SourceService sourceService;

    @Autowired
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/submitSource")
    public ResponseEntity<ResponseMessage<Source>> submitSource(@RequestBody Source source) {


        ResponseMessage<Source> responseMessage= sourceService.insert(source);
        return new ResponseEntity<>(responseMessage, responseMessage.getHttpStatus());
    }
}
