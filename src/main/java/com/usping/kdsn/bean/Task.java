package com.usping.kdsn.bean;

import com.usping.kdsn.util.model.BaseEntity;

public class Task extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.id
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.Title
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.location
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.uid
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.companyname
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String companyname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.price
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private Integer price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.URL
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.Picture
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.Keywords
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    private String keywords;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.id
     *
     * @return the value of task.id
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.id
     *
     * @param id the value for task.id
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.Title
     *
     * @return the value of task.Title
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.Title
     *
     * @param title the value for task.Title
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.location
     *
     * @return the value of task.location
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.location
     *
     * @param location the value for task.location
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.uid
     *
     * @return the value of task.uid
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.uid
     *
     * @param uid the value for task.uid
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.companyname
     *
     * @return the value of task.companyname
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.companyname
     *
     * @param companyname the value for task.companyname
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.price
     *
     * @return the value of task.price
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.price
     *
     * @param price the value for task.price
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.URL
     *
     * @return the value of task.URL
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.URL
     *
     * @param url the value for task.URL
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.Picture
     *
     * @return the value of task.Picture
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.Picture
     *
     * @param picture the value for task.Picture
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.Keywords
     *
     * @return the value of task.Keywords
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.Keywords
     *
     * @param keywords the value for task.Keywords
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }
}