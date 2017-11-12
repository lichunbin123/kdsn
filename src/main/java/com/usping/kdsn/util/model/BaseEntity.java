package com.usping.kdsn.util.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Created by stan on 17-7-2.
 */
public class BaseEntity {
  @Transient
  private Integer page = 1;

  @Transient
  private Integer rows = 10;

  @Transient
  private String sortBy = "";

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getRows() {
    return rows;
  }

  public void setRows(Integer rows) {
    this.rows = rows;
  }

  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }
}
