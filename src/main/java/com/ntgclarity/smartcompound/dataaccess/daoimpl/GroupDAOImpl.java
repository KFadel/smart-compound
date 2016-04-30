package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.GroupDAO;

@Repository
public class GroupDAOImpl extends BaseDAO implements GroupDAO {

	@Override
	public List<Group> getAllGroups() {

		return (List<Group>) super.getAll(Group.class);
	}

	@Override
	public Group getGroup(Long id) {
		return  (Group) super.get(Group.class , id);
	}
	@Override
	public Group updateGroup(Group group) {
		// TODO Auto-generated method stub
		return (Group) super.saveOrUpdate(group);
	}

	/**
	 *methodCreater:nessma 
	 *create Group 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Group insertGroup(Group group) {
		
		return (Group) super.saveOrUpdate(group);
		
		
	}
	@Override
	public List<Group> loadGroups(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return super.load(Group.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfGroupsRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Group.class,filters);
	}

}
