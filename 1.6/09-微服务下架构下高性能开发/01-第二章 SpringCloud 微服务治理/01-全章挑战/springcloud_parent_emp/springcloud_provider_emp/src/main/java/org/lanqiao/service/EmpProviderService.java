package org.lanqiao.service;

public interface EmpProviderService {
    /**
     * 查询所有员工信息
     * @return
     */
    Object selectAllEmp();

    /**
     * 根据员工编号查询员工信息
     * @param eNo 员工编号
     * @return
     */
    Object selectEmpByEno(Integer eNo);
}
