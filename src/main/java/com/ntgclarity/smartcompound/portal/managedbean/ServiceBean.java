package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;
import com.ntgclarity.smartcompound.common.entity.Service;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class ServiceBean extends BaseBean implements Serializable {

	/**
	 * 
	 */
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;

	private static final long serialVersionUID = 1L;
	private Service createdService;
	private List<Compound> compounds;
	private List<Lookup> measuringUnits;
	private String isActive = "0", postPre = "0";
	private LazyDataModel<Service> lazyServiceModel;

	@PostConstruct
	public void init() {
		createdService = new Service();
		compounds = new ArrayList<Compound>();
		measuringUnits = new ArrayList<>();
		loadCompoundList();
		loadMeasuringUnits();
		LoadData();
	}

	public void loadMeasuringUnits() {
		LookupType lookupType1 = new LookupType();
		lookupType1.setId(1L);
		lookupType1.setTypeName("measuringUnitType");
		Lookup lookup = new Lookup();
		lookup.setLookupName("Litre");
		lookup.setTypeName(lookupType1.getTypeName());
		measuringUnits.add(lookup);
	}

	public void loadCompoundList() {
		Compound compound1 = new Compound();
		compound1.setCompoundName("El Rehab Compound");
		compound1.setId(1L);
		compounds.add(compound1);
	}

	private void LoadData() {
		lazyServiceModel = new LazyDataModel<Service>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Service> result;

			@Override
			public Service getRowData(String rowKey) {
				for (Service service : result) {
					if (service.getId().toString().equals(rowKey))
						return service;
				}
				return null;
			}
			@Override
			public Object getRowKey(Service service) {
				return service.getId();
			}
			@Override
			public List<Service> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadServices(first,pageSize, sortField, sortOrder == SortOrder.ASCENDING,filters);
				this.setRowCount(getSmartCompoundManagment().getNumOfServicesRows(filters));
				return result;
			}
			@Override
			public void forEach(Consumer<? super Service> action) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public Spliterator<Service> spliterator() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Service getCreatedService() {
		return createdService;
	}

	public void setCreatedService(Service createdService) {
		this.createdService = createdService;
	}

	public List<Compound> getCompounds() {
		return compounds;
	}

	public void setCompounds(List<Compound> compounds) {
		this.compounds = compounds;
	}

	public List<Lookup> getMeasuringUnits() {
		return measuringUnits;
	}

	public void setMeasuringUnits(List<Lookup> measuringUnits) {
		this.measuringUnits = measuringUnits;
	}

	public LazyDataModel<Service> getLazyServiceModel() {
		return lazyServiceModel;
	}

	public void setLazyServiceModel(LazyDataModel<Service> lazyServiceModel) {
		this.lazyServiceModel = lazyServiceModel;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getPostPre() {
		return postPre;
	}

	public void setPostPre(String postPre) {
		this.postPre = postPre;
	}

	public void insertService() throws SmartCompoundException {
		createdService.setIsActive(Integer.parseInt(isActive));
		createdService.setIsPrepaid(Integer.parseInt(postPre));
		smartCompoundManagment.insertService(createdService);

	}
}
