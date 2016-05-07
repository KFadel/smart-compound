package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.constatnt.MessagesKeys;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean implements Serializable {

	 
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	    	
	private Employee selectedEmployee;
	
	private static final long serialVersionUID = 1L;

	private List<Employee> allEmployees;

	@PostConstruct
	public void init()throws SmartCompoundException {	
//		loadAllEmployees(); 
		initiateEmployee();
	}

	public void loadAllEmployees() throws SmartCompoundException{
		allEmployees = smartCompoundManagment.getAllEmployees();
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(List<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	/**START HEBA'S WORK**/	
	public Employee initiateEmployee(){
		selectedEmployee = new Employee();
		return selectedEmployee;
	}
	
	public void insertEmployee(){
		smartCompoundManagment.insertEmployee(selectedEmployee);
		addInfoMessage(MessagesKeys.SMART_COMPOUND_EMPLOYEE_PAGE_EMPLOYEE_INSERTION_MESSAGE);
	}	
	/**END HEBA'S WORK**/
}
