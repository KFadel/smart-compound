package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.constatnt.MessagesKeys;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	private List<Employee> allEmployees;	    
	
	private Employee selectedEmployee;
	private LazyDataModel<Employee> lazyEmployeeModel;

	@PostConstruct
	public void init()throws SmartCompoundException {	
//		loadAllEmployees(); 
		initiateEmployee();
		LoadData();
	}

	private void LoadData() {
		lazyEmployeeModel = new LazyDataModel<Employee>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Employee> result;

			@Override
			public Employee getRowData(String rowKey) {
				for (Employee employee : result) {
					if (employee.getId().toString().equals(rowKey))
						return employee;
				}

				return null;
			}

			@Override
			public Object getRowKey(Employee employee) {
				return employee.getId();
			}

			@Override
			public List<Employee> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadEmployees(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				this.setRowCount(getSmartCompoundManagment()
						.getNumOfEmployeesRows(filters));

				return result;
			}

		};
		
	}

//	public void loadAllEmployees() throws SmartCompoundException{
//		allEmployees = smartCompoundManagment.getAllEmployees();
//	}
//
//	public void testMethod() throws SmartCompoundException {
//
//		loadAllEmployees();
//	}
//	
//	
//	public void printEmployee()
//	{
//		System.out.println(selectedEmployee);
//	}

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
	
	public LazyDataModel<Employee> getLazyEmployeeModel() {
		return lazyEmployeeModel;
	}



	/**START HEBA'S WORK**/	
	public void initiateEmployee(){
		selectedEmployee = new Employee();
//		return selectedEmployee;
	}
	public void setLazyEmployeeModel(LazyDataModel<Employee> lazyEmployeeModel) {
		this.lazyEmployeeModel = lazyEmployeeModel;
	}

	
	public void insertEmployee(){
		smartCompoundManagment.insertEmployee(selectedEmployee);
		addInfoMessage(MessagesKeys.SMART_COMPOUND_EMPLOYEE_PAGE_EMPLOYEE_INSERTION_MESSAGE);
	}	
	
	private boolean skip;

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
	/**END HEBA'S WORK**/
}
