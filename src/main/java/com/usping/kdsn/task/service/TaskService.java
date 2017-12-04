package com.usping.kdsn.task.service;

import com.usping.kdsn.bean.Task;

import java.util.HashMap;
import java.util.List;

public interface TaskService {
    public List<Task> findAll();

    HashMap<String,Object> findTaskForUser(int start, int size);
}
