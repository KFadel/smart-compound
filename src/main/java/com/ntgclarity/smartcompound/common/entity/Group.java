package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Entity
@Table(name = "ng_nts_groups")
public class Group  extends BaseEntity implements Serializable{
	@Id
	@GeneratedValue(generator = "my_gen")
	@SequenceGenerator(name = "my_gen", sequenceName = "ng_nts_groups_recid_seq")
	@Column(name = "recid")
	private Long id;
	@Column (name="group_name")
	private String groupName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
