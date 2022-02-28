package org.lanqiao.entity;
import java.util.List;

public class Page<T> {
    private int totalPage;          // 总页数
    private int totalCount;         // 数据总数，即一共有多少条数据需要显示
    private int pageSize;           // 页面大小，即每页显示几条数据
    private int currentPage;        // 当前页的页码
    private List<T> list; // 实体类集合，如 List<List> list
    private String parm;


    // 不存在 总页数 的setter方法，因为总页数是由 数据总数 和页面大小 计算而来的
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        // 自动计算出 总页数
        totalPage = this.totalCount % pageSize == 0 ? (this.totalCount/pageSize) : this.totalCount/pageSize+1;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public java.util.List<T> getList() {
        return list;
    }

    public void setList(java.util.List<T> list) {
        this.list = list;
    }

    public String getParm() {
        return parm;
    }

    public void setParm(String parm) {
        this.parm = parm;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }
}