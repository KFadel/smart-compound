package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.common.entity.MenuItem;

public interface GroupService {

	List<Group> getAllGroups();

	Group getGroup(Long id);

	Group insertGroup(Group group);
	List<MenuItem> getGroupMenuItem(Group group);
    void insertGroupMenuItem(Group group,List<MenuItem> items);

	Group updateGroup(Group group);
	List<Group> loadGroups(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfGroupsRows(Map<String, Object> filters);

}
