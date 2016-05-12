package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Entity
@Table(name = "ng_nts_lookup_types")
public class LookupType extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8041531328826352542L;
	
	
	public final static LookupType STATUS = new LookupType(1l);
	public final static LookupType MEASUREMENT_UNITES = new LookupType(2l);
	
			
			
	public LookupType() {
	}
	public LookupType(Long id) {
		super();
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private Long id;
	@Column(name="type_name")
	private String typeName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "LookupType [id=" + id + ", typeName=" + typeName + "]";
	}
	

}
