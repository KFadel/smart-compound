package com.ntgclarity.smartcompound.business.management;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);
	
	public void updateCompound(Compound compound);
	
	public void insertCompound(Compound compound);

}
