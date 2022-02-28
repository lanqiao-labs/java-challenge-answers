package org.lanqiao.service;

import org.lanqiao.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpProviderServiceImpl implements EmpProviderService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Object selectAllEmp() {
        return empMapper.selectList(null);
    }

    @Override
    public Object selectEmpByEno(Integer eNo) {
        return empMapper.selectById(eNo);
    }
}
