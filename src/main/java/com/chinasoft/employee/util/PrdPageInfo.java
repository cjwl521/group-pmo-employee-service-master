package com.chinasoft.employee.util;

import java.util.List;

public class PrdPageInfo<T>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    //当前页
    private int page;
    //每页的数量
    private int pagesize;
    
    private int pages;
    
    private long total;
    
    private List<T> list;
    
   
    
    
    
    
    public long getTotal() {
        return total;
    }



    public void setTotal(long total) {
        this.total = total;
    }



    public List<T> getList() {
        return list;
    }



    public void setList(List<T> list) {
        this.list = list;
    }



    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    public int getPages() {
        return pages;
    }




    public void setPages(int pages) {
        this.pages = pages;
    }



    public int getPage() {
        return page;
    }



    public int getPagesize() {
        return pagesize;
    }



    public void setPage(int page) {
        this.page = page;
    }



    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }


    
}
