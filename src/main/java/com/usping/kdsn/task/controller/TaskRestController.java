package com.usping.kdsn.task.controller;

import com.usping.kdsn.bean.Task;
import com.usping.kdsn.task.service.TaskServiceImpl;
import com.usping.kdsn.util.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task/")
public class TaskRestController {
    private final TaskServiceImpl taskService;

    @Autowired
    public TaskRestController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping("task")
    public ResponseEntity<List<Task>> findAll(){
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    /**
     * return task list to user with pagination
     * @param task
     * @return
     */
    @CrossOrigin
    @GetMapping("getTaskForUser")
    public ResponseEntity<Map<String,Object>> findTaskForUser(Task task) {
        try{
            ResultMap resultMap = taskService.findTaskForUser(task.getOffset(), task.getPageSize());
            if(resultMap.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
