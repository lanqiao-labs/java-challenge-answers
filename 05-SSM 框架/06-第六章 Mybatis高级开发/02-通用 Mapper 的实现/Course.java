package org.lanqiao.entity;

import javax.persistence.*;

@Table(name = "`course`")
public class Course {
    @Id
    @Column(name = "`cNo`")
    private Integer cno;

    @Column(name = "`cName`")
    private String cname;

    @Column(name = "`teacher`")
    private String teacher;

    /**
     * @return cNo
     */
    public Integer getCno() {
        return cno;
    }

    /**
     * @param cno
     */
    public void setCno(Integer cno) {
        this.cno = cno;
    }

    /**
     * @return cName
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * @return teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}