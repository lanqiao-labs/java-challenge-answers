package org.lanqiao.entity;

public class Department {
    //部门编号
    private int deptNo;
    //部门名称
    private String dName;
    //部门地址
    private String loc;

    public int getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDName() {
        return this.dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    @Override
    public String toString() {
        return "{" +
            " deptNo='" + getDeptNo() + "'" +
            ", dName='" + getDName() + "'" +
            ", loc='" + getLoc() + "'" +
            "}";
    }
}