package com.usping.kdsn.auth.controller;

import com.usping.kdsn.auth.model.User;
import com.usping.kdsn.auth.service.UserService;
import java.util.List;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stan on 17-7-2.
 */

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
  private final UserService userService;

  @Autowired
  public AuthRestController(UserService userService) {
    this.userService = userService;
  }

  // retrieve user list
  @CrossOrigin
  @GetMapping(value = "/user")
  public ResponseEntity<List>
  findAll() {
    ResponseEntity<List> responseEntity = new ResponseEntity<List>(userService.findAll(), HttpStatus.ACCEPTED);
    return responseEntity;
  }

  // retrieve user by id
  @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
  public User
  findUser(@PathVariable("id")Integer id){
    return userService.findById(id);
  }

  // create user
//  @RequestMapping(value = "/user",method = RequestMethod.POST)
//  public boolean
//  createUser(User user) {
//    return userService.saveUser(user);
//  }

  //// update user
  //@RequestMapping(value ="/user/{id}",method = RequestMethod.POST)
  //public boolean
  //updateUser(User user,@PathVariable("id")Integer id){
  //  return userService.updateUser(user);//
  //}

  //@SelectProvider("")

  @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
  public boolean
    deleteUser(@PathVariable("id")Integer id){
    return userService.deleteUser(id);
  }
}
