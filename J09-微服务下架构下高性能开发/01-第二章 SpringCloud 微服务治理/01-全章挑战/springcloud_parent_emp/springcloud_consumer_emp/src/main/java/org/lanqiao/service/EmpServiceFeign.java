package org.lanqiao.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("springcloud-provider-emp")
public interface EmpServiceFeign {

    /**
     * 查询所有员工信息
     * @return
     */
    @GetMapping("/emp/selectAllEmp")
    public Object selectAllEmp();

    /**
     * 根据员工编号查询员工信息
     * @param eNo 员工编号
     * @return
     */
    @GetMapping("/emp/selectEmpByEno")
    public Object selectEmpByEno(@RequestParam("eNo") Integer eNo);
}
