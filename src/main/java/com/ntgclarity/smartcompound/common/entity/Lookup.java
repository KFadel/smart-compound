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
	/**
	 * 
	 */
	private static final long serialVersionUID = -6344103690626600369L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private Long id;
	@Column (name="lookup_name")
	private String lookupName;
	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName = "recid")
	private LookupType lookupType;
	@Column(name="type_name")
	private String typeName;
	
	
	public LookupType getLookupType() {
		return lookupType;
	}

	public void setLookupType(LookupType lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
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
		return "LookUp [id=" + id + ", lookupName=" + lookupName + ", lookupType="
				+ lookupType + ", typeName=" + typeName + "]";
	}
	

}
