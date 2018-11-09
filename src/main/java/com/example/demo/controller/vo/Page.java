package com.example.demo.controller.vo;

/**
 * @author wangxl
 * @date 2018/11/3
 */
public class Page {
    private int pageNo;
    private int pageSize;
    private int pageStart;

    public int getPageStart() {
        return (getPageNo()-1)*getPageSize();
    }

    public void setPageStart() {
        this.pageStart = (getPageNo()-1)*getPageSize();
    }

    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public static void main(String[] args) {
        Page page = new Page();
        page.setPageNo(2);
        page.setPageSize(10);
        System.out.println(page.getPageStart());
    }
}
