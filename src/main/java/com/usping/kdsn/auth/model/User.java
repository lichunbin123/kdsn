package com.usping.kdsn.auth.model;

import com.usping.kdsn.util.model.BaseEntity;
import javax.persistence.Column;
import org.springframework.beans.factory.annotation.Value;

/**
 * designed for auth module
 * Created by stan on 17-7-2.
 */
public class User extends BaseEntity {

  private String username;

  private String name;

  private String email;

  private String phone;

  private String industry;

  private String assortment;

  @Column(name = "userrole")
  private int user_role;

  @Column(name = "job_location")
  private String job_location;

  private String school;

  @Column(name = "workexperience")
  private String work_experience;

  @Column(name = "projectexperience")
  private String project_experience;

  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getAssortment() {
    return assortment;
  }

  public void setAssortment(String assortment) {
    this.assortment = assortment;
  }

  public int getUser_role() {
    return user_role;
  }

  public void setUser_role(int user_role) {
    this.user_role = user_role;
  }

  public String getJob_location() {
    return job_location;
  }

  public void setJob_location(String job_location) {
    this.job_location = job_location;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getWork_experience() {
    return work_experience;
  }

  public void setWork_experience(String work_experience) {
    this.work_experience = work_experience;
  }

  public String getProject_experience() {
    return project_experience;
  }

  public void setProject_experience(String project_experience) {
    this.project_experience = project_experience;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
