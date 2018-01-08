package com.usping.kdsn.util.tool;

import com.usping.kdsn.bean.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author: stan
 * @date: 4/12/17
 * description:
 */
public class MenuMap extends HashMap<String, Object> {
//    private int id;
//    private String label;
//    private MenuMap children;

    public MenuMap() {
    }

    public MenuMap setId(int id) {
        this.put("id", id);
        return this;
    }

    public String getLabel() {
        return (String) this.get("label");
    }

    public MenuMap setLabel(String label) {
        this.put("label", label);
        return this;
    }

    public MenuMap setChildren(List<MenuMap> children) {
        this.put("children", children);
        return this;
    }

    public MenuMap setChecked() {
        this.put("checked", true);
        return this;
    }

    public List<MenuMap> getChildren() {
        return (List<MenuMap>) this.get("children");
    }

    public boolean hasChild() {
        return this.get("children") != null;
    }

    public static HashMap createMenu(List<Menu> menuList) {
        HashMap hashMap = new HashMap();

        List<MenuMap> menuMapList = new ArrayList<>();

        int i = 0 ;
        for (Menu m: menuList){
            MenuMap tmp = new MenuMap().setId(i++).setLabel(m.getSiteType()).setChildren(new ArrayList<>());
            menuMapList.add(tmp);
        }

        for (Menu m: menuList){
            for(MenuMap map:menuMapList){
                if (Objects.equals(m.getSiteType(), map.getLabel())){
                    map.getChildren().add(new MenuMap().setId(m.getId()).setLabel(m.getSiteName()));
                }
            }
        }

        hashMap.put("data", menuMapList);

        return hashMap;
    }

    /**
     *  data2: [{
     id: 1,
     label: '一级 1',
     children: [{
     id: 4,
     label: '二级 1-1',
     children: [{
     id: 9,
     label: '三级 1-1-1'
     }, {
     id: 10,
     label: '三级 1-1-2'
     }]
     }]
     }, {
     id: 2,
     label: '一级 2',
     children: [{
     id: 5,
     label: '二级 2-1'
     }, {
     id: 6,
     label: '二级 2-2'
     }]
     }, {
     id: 3,
     label: '一级 3',
     children: [{
     id: 7,
     label: '二级 3-1'
     }, {
     id: 8,
     label: '二级 3-2'
     }]
     }],
     */
}
