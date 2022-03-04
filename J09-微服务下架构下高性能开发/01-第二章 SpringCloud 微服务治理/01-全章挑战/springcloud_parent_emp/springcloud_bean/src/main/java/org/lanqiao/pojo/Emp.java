package org.lanqiao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
/**
 * 定义一个员工类 Emp
 * @author lanqiao
 */

public class Emp{
    // 员工编号
    @TableId
    private Integer eNo;
    //员工姓名
    private String eName;
    //岗位
    private String job;
    //直接上级
    private Integer mgr;
    //入职日期
    private Date hireDate;
    //工资
    private Double sal;
    //奖金
    private Double comm;
    //部门编号
    private Integer dNo;

    public Integer getENo() {
        return this.eNo;
    }

    public void setENo(Integer eNo) {
        this.eNo = eNo;
    }

    public String getEName() {
        return this.eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return this.mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSal() {
        return this.sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return this.comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDNo() {
        return this.dNo;
    }

    public void setDNo(Integer dNo) {
        this.dNo = dNo;
    }

    @Override
    public String toString() {
        return "{" +
            " eNo='" + getENo() + "'" +
            ", eName='" + getEName() + "'" +
            ", job='" + getJob() + "'" +
            ", mgr='" + getMgr() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", sal='" + getSal() + "'" +
            ", comm='" + getComm() + "'" +
            "}";
    }
}