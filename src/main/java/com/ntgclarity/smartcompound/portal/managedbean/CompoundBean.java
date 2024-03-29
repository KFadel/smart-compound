package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.constatnt.MessagesKeys;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class CompoundBean extends BaseBean implements Serializable {
	
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	private Compound selectedCompound;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
		
		initNewCompound();
	}
	
	public void initNewCompound(){
		selectedCompound=new Compound();
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Compound getCompound() {
		return selectedCompound;
	}

	public void setCompound(Compound selectedCompound) {
		this.selectedCompound = selectedCompound;
	}
	
	public void insertCompound(){
		smartCompoundManagment.insertCompound(selectedCompound);
		addInfoMessage(MessagesKeys.SMART_COMPOUND_COMPOUND_PAGE_COMPOUND_INSERTION_MESSAGE);
	}
	
	//public void updateCompound(){
		//smartCompoundManagment.updateCompound(compound);
		
	//}

}
