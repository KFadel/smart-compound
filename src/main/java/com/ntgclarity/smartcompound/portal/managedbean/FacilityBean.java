package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.constatnt.MessagesKeys;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class FacilityBean extends BaseBean implements Serializable {
	
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	private Facility selectedFacility;
	private LazyDataModel<Facility> lazyFacilityModel;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
		initiateFacility();
		LoadData();
	}
	
	public void initiateFacility(){
		selectedFacility=new Facility();
	}
	
	private void LoadData() {
		lazyFacilityModel = new LazyDataModel<Facility>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Facility> result;

			@Override
			public Facility getRowData(String rowKey) {
				for (Facility employee : result) {
					if (employee.getId().toString().equals(rowKey))
						return employee;
				}

				return null;
			}

			@Override
			public Object getRowKey(Facility facility) {
				return facility.getId();
			}

			@Override
			public List<Facility> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadFacilities(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				this.setRowCount(getSmartCompoundManagment()
						.getNumOfFacilitiesRows(filters));

				return result;
			}

		};
		
	}

	

	public void insertFacility() throws SmartCompoundException{
		smartCompoundManagment.insertFacility(selectedFacility);
		addInfoMessage(MessagesKeys.SMART_COMPOUND_COMPOUND_PAGE_COMPOUND_INSERTION_MESSAGE);
	}
	
	//public void updateCompound(){
		//smartCompoundManagment.updateCompound(compound);
		
	//}

	
	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}
	
	public Facility getSelectedFacility() {
		return selectedFacility;
	}

	public void setSelectedFacility(Facility selectedFacility) {
		this.selectedFacility = selectedFacility;
	}
	
	public LazyDataModel<Facility> getLazyFacilityModel() {
		return lazyFacilityModel;
	}

	public void setLazyFacilityModel(LazyDataModel<Facility> lazyFacilityModel) {
		this.lazyFacilityModel = lazyFacilityModel;
	}
}
