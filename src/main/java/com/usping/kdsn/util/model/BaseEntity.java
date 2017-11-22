package com.usping.kdsn.util.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by stan on 17-7-2.
 */
public class BaseEntity implements Pageable{
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


  @Override
  public int getPageNumber() {
    return 0;
  }

  @Override
  public int getPageSize() {
    return 0;
  }

  @Override
  public int getOffset() {
    return 0;
  }

  @Override
  public Sort getSort() {
    return null;
  }

  @Override
  public Pageable next() {
    return null;
  }

  @Override
  public Pageable previousOrFirst() {
    return null;
  }

  @Override
  public Pageable first() {
    return null;
  }

  @Override
  public boolean hasPrevious() {
    return false;
  }
}
