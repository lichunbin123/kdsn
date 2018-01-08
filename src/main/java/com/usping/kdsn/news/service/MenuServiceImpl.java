package com.usping.kdsn.news.service;

import com.usping.kdsn.bean.Menu;
import com.usping.kdsn.mapper.MenuMapper;
import com.usping.kdsn.util.tool.MenuMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author: stan
 * @date: 4/12/17
 * description:
 */

@Component
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;
    private final NewsServiceImpl newsService;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper, NewsServiceImpl newsService) {
        this.menuMapper = menuMapper;
        this.newsService = newsService;
    }

    @Override
    public boolean save(Menu menu) {
        return menuMapper.insert(menu) != 0;
    }

    /**
     * 遍历所有分类,产生一级目录
     * 遍历所有分类下的url, 产生一级目录的子目录
     * 同时产生checkedList
     *
     * @param userId
     * @return 产生vueTree可以使用的树菜单
     * //
     */
    @Override
    public HashMap<String, List> createMenu(int userId) {
        List<MenuMap> menuData = new ArrayList<>();
        List<String> checkedList = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        HashMap returnMap = new HashMap();

        menuMapper.selectByUserId(6).forEach((k) -> {
            set.add(k.getSiteName());
        });

        HashMap hashMap = newsService.findDistinct();

        for (Object i : hashMap.keySet()) {
            List<MenuMap> menuMapList = new LinkedList<>();

            // 创建二级目录
            for (String s : (List<String>) hashMap.get(i)) {
                menuMapList.add(new MenuMap().setId(s.hashCode()).setLabel(s));
                if (!set.contains(s)) {
                    checkedList.add(String.valueOf(s.hashCode()));
                }
            }

            // 创建一级目录
            MenuMap t = new MenuMap().setId(i.hashCode()).setLabel(i.toString()).setChildren(menuMapList).setChecked();
            menuData.add(t);
        }

        returnMap.put("data", menuData);
        returnMap.put("checkedList", checkedList);

        return returnMap;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List<Menu> findMenuByUserId(int userId) {
        return menuMapper.selectByUserId(userId);
    }

}
