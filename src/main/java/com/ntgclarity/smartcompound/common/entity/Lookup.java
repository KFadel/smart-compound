package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Entity
@Table(name = "ng_nts_lookup")
public class Lookup  extends BaseEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rec_id")
	private Long id;
	@Column (name="lookup_name")
	private String lookupName;
	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName = "rec_id")
	private LookupType type_id;
	@Column(name="type_name")
	private String typeName;
	
	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public LookupType getType_id() {
		return type_id;
	}

	public void setType_id(LookupType type_id) {
		this.type_id = type_id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public Long getId() {
		
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
		
	}

	@Override
	public String toString() {
		return "LookUp [id=" + id + ", lookupName=" + lookupName + ", type_id="
				+ type_id + ", typeName=" + typeName + "]";
	}
	

}
