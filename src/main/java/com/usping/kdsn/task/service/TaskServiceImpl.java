package com.usping.kdsn.task.service;

import com.usping.kdsn.bean.Task;
import com.usping.kdsn.bean.TaskExample;
import com.usping.kdsn.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public List<Task> findAll() {
//        return taskMapper;
        return taskMapper.selectByExample(new TaskExample());
    }
}
