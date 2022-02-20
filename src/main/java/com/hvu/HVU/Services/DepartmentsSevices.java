package com.hvu.HVU.Services;

import com.hvu.HVU.Repository.DepartmentsRepository;
import com.hvu.HVU.entity.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsSevices {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    public void addDepartments(List<Departments> departments){
        departmentsRepository.saveAll(departments);
    }
}
