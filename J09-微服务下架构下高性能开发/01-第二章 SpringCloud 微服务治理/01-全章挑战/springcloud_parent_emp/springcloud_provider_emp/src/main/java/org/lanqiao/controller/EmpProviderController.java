package org.lanqiao.controller;

import org.lanqiao.service.EmpProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpProviderController {
    @Autowired
    private EmpProviderService empProviderService;

    @GetMapping("/selectAllEmp")
    public Object selectAllEmp(){
        return empProviderService.selectAllEmp();
    }

    @GetMapping("/selectEmpByEno")
    public Object selectEmpByEno(Integer eNo){
        return empProviderService.selectEmpByEno(eNo);
    }
}
