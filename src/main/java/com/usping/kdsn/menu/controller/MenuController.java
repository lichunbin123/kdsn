package com.usping.kdsn.menu.controller;

import com.usping.kdsn.bean.Menu;
import com.usping.kdsn.news.service.MenuService;
import com.usping.kdsn.news.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: stan
 * @date: 8/01/18
 * description:
 */
@RequestMapping("/menu/")
@RestController
public class MenuController {

    private final MenuService menuService ;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @CrossOrigin
    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> findAll(){
        return new ResponseEntity<>(menuService.findAll(), HttpStatus.OK);
    }
}
