package org.lanqiao.pojo;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 定义一个部门类 Dept
 * @author lanqiao
 */
public class Dept {
    //部门编号
    @TableId
    private Integer dNo;
    //部门名称
    private String dName;
    //部门地址
    private String address;

    public Integer getDNo() {
        return this.dNo;
    }

    public void setDNo(Integer dNo) {
        this.dNo = dNo;
    }

    public String getDName() {
        return this.dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "{" +
            " deptNo='" + getDNo() + "'" +
            ", dName='" + getDName() + "'" +
            ", loc='" + getAddress() + "'" +
            "}";
    }
}