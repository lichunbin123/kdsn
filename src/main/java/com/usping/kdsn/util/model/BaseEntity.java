package com.usping.kdsn.util.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by stan on 17-7-2.
 */
public class BaseEntity {
    @Transient
    private Integer pageNumber = 0;

    @Transient
    private Integer pageSize = 10;

    @Transient
    private String sortBy = "";

    @Transient
    private boolean isAsc = true;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getOffset() {
        return (this.pageNumber - 1) * this.getPageSize();
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }
}
