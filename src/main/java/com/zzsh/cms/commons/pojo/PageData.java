package com.zzsh.cms.commons.pojo;

import java.util.List;

/**
 * @program: cms
 * @description: 分页数据对象
 * @author: 彭博文
 * @create: 2018-06-28 08:02
 **/
public class PageData<T> {

    /*每页数据条数*/
    private Integer pageSize;
    /*总数据量*/
    private Integer totalCount;
    /*当前页码*/
    private Integer currentPage;
    /*总页数*/
    private Integer pageCount;
    /*数据*/
    private List<T>  dataList;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
