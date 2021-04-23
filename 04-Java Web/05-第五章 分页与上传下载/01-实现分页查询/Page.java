package org.lanqiao.entity;
import java.util.List;

public class Page {
    private int totalPage;          // 总页数
    private int totalCount;         // 数据总数，即一共有多少条数据需要显示
    private int pageSize;           // 页面大小，即每页显示几条数据
    private int currentPage;        // 当前页的页码
    private List<User> users; // 实体类集合，如 List<Student> students,用来保存当前页面中全部学生的信息

    // 不存在“总页数”的 setter 方法，因为总页数是由“数据总数”和“页面大小”计算而来的
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        // 自动计算出“总页数”
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", users=" + users +
                '}';
    }
}