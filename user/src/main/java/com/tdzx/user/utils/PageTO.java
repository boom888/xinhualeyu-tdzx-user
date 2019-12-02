package com.tdzx.user.utils;

import java.io.Serializable;
import java.util.List;

public class PageTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 当前页
    private int pageNum;
    // 总记录数
    private long total;
    // 总页数
    private int pages;
    // 结果集
    private List<T> list;
    // 每页的数量
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageTO(Integer pageNum, Integer pageSize) {
        super();
        if (pageNum == null) {
            pageNum = Constant.NUM_ONE;
        }
        if (pageSize == null) {
            pageSize = Constant.PAGE_SIZE;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageTO(Integer pageNum) {
        this(pageNum, Constant.PAGE_SIZE);
    }

    public PageTO() {
    }

    public PageTO(com.github.pagehelper.Page<T> page, List<T> data) {
        this.list = data;
        this.pageNum = page.getPageNum();
        this.pages = page.getPages();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
    }

}
