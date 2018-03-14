package com.usping.kdsn.auth.controller;

import com.usping.kdsn.auth.service.UserService;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.bean.UserWithBLOBs;
import com.usping.kdsn.util.model.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by stan on 17-7-2.
 */

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

  private final Logger logger = LoggerFactory.getLogger(AuthRestController.class);

  private final UserService userService;

  @Autowired
  public AuthRestController(UserService userService) {
    this.userService = userService;
  }

  @CrossOrigin
  @GetMapping(value = "/user")
  public ResponseEntity<List> listAll() {
    ResponseEntity<List> responseEntity = new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    return responseEntity;
  }

  @CrossOrigin
  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public User findUser(@PathVariable("id") Integer id) {
    return userService.findById(id);
  }

  //// update user
  //@RequestMapping(value ="/user/{id}",method = RequestMethod.POST)
  //public boolean
  //updateUser(User user,@PathVariable("id")Integer id){
  //  return userService.updateUser(user);//
  //}

  //@SelectProvider("")

  @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
  public boolean
  deleteUser(@PathVariable("id") Integer id) {
    return userService.deleteUser(id);
  }

}