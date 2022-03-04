package org.lanqiao.controller;

import org.lanqiao.service.EmpServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consumer/emp")
@RestController
public class EmpConsumerController {

    @Autowired
    private EmpServiceFeign empServiceFeign;

    @GetMapping("/findAllEmp")
    public Object findAllEmp(){
        return empServiceFeign.selectAllEmp();
    }

    @GetMapping("/findEmpByEno")
    public Object findEmpByEno(Integer eNo){
        return empServiceFeign.selectEmpByEno(eNo);
    }
}
