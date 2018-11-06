package com.usping.kdsn.util.model;



/**
 * Created by ning on 17-7-2.
 */
public class BaseEntity {
    private Integer pageNumber = 1;

    private Integer pageSize = 10;

    private String sortBy = "";

    private boolean isAsc = true;

    private Integer offset = 0;

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

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public BaseEntity() {
    }
}
