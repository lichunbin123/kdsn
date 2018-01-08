package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Menu;

import java.util.HashMap;
import java.util.List;

public interface MenuService {
    boolean save(Menu menu);

    HashMap createMenu(int userId);

    List findAll();

    List findMenuByUserId(int userId);
}
