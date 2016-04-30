package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Group;

public interface GroupDAO {

	List<Group> getAllGroups();

	Group getGroup(Long id);

	Group insertGroup(Group group);

	Group updateGroup(Group group);
	
	List<Group> loadGroups(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfGroupsRows(Map<String, Object> filters);

}
