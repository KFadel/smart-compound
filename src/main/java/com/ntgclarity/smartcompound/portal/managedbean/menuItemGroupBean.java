package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.common.entity.MenuItem;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class menuItemGroupBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	List<Group> allGroup ;
	List<MenuItem> allMenuItem ;
	
	Group selectedGroup;
   List<MenuItem> selectedMenuItem;
    
    Boolean check= true;
    List<MenuItem> selectedItems;
	
    
    public void onGroupChange(){
    	selectedItems = smartCompoundManagment.getGroupMenuItem(selectedGroup);
    }

	@PostConstruct
	public void init() {
		
		loadAllGroup();
		loadAllMenuItem();
	/*	/Group group = new Group();
		group.setId(1L);
		selectedGroup=group;
	    selectedItems=smartCompoundManagment.getGroupMenuItem(selectedGroup);*/
	}

	private void loadAllMenuItem() {
		// TODO Auto-generated method stub
		allMenuItem=smartCompoundManagment.getAllMenuItems();
		System.out.println("in load all menuitems ===> menuitems Size = " +allMenuItem.size() );

		
	}

	private void loadAllGroup() {
		// TODO Auto-generated method stub
		allGroup= smartCompoundManagment.getAllGroup();
		System.out.println("in load all group ===> Group Size = " +allGroup.size() );
		
		
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public List<Group> getAllGroup() {
		return allGroup;
	}
	
	public void saveSelectedMenus(){
		
		smartCompoundManagment.insertGroupMenuItem(selectedGroup,selectedItems );
		
	}

	public void setAllGroup(List<Group> allGroup) {
//		System.out.println("allGroup : " + allGroup);
		this.allGroup = allGroup;
	}

	public List<MenuItem> getAllMenuItem() {
		return allMenuItem;
	}

	public void setAllMenuItem(List<MenuItem> allMenuItem) {
		this.allMenuItem = allMenuItem;
	}

	public Group getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(Group selectedGroup) {
//		System.out.println("selectedGroup "+ selectedGroup);
		this.selectedGroup = selectedGroup;
	}

	public List<MenuItem> getSelectedMenuItem() {
		return selectedMenuItem;
	}

	public void setSelectedMenuItem(List<MenuItem> selectedMenuItem) {
		this.selectedMenuItem = selectedMenuItem;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public List<MenuItem> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<MenuItem> selectedItems) {
		this.selectedItems = selectedItems;
	}


}
