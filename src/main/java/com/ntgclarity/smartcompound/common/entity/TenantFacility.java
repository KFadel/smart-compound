package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "ng_nts_tenants_facilities")
public class TenantFacility extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rec_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "tenant_id", referencedColumnName = "rec_id")
	private Tenant tenantId;
	@ManyToOne
	@JoinColumn(name = "facility_id", referencedColumnName = "rec_id")
	private Facility facilityId;
	@ManyToOne
	@JoinColumn(name = "compound_id", referencedColumnName = "rec_id")
	private Compound compoundId;
	@Column(name = "is_leased")
	private Integer isLeased;
	@Column(name = "leasing_or_ownership_start_date")
	private Date leasingOrOwnershipStartDate;
	@Column(name = "leasing_or_ownership_end_date")
	private Date leasingOrOwnershipEndDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tenant getTenantId() {
		return tenantId;
	}
	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	public Facility getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Facility facilityId) {
		this.facilityId = facilityId;
	}
	public Compound getCompoundId() {
		return compoundId;
	}
	public void setCompoundId(Compound compoundId) {
		this.compoundId = compoundId;
	}
	public Integer getIsLeased() {
		return isLeased;
	}
	public void setIsLeased(Integer isLeased) {
		this.isLeased = isLeased;
	}
	public Date getLeasingOrOwnershipStartDate() {
		return leasingOrOwnershipStartDate;
	}
	public void setLeasingOrOwnershipStartDate(Date leasingOrOwnershipStartDate) {
		this.leasingOrOwnershipStartDate = leasingOrOwnershipStartDate;
	}
	public Date getLeasingOrOwnershipEndDate() {
		return leasingOrOwnershipEndDate;
	}
	public void setLeasingOrOwnershipEndDate(Date leasingOrOwnershipEndDate) {
		this.leasingOrOwnershipEndDate = leasingOrOwnershipEndDate;
	}
	@Override
	public String toString() {
		return "TenantFacility [id=" + id + ", tenantId=" + tenantId
				+ ", facilityId=" + facilityId + ", compoundId=" + compoundId
				+ ", isLeased=" + isLeased + ", leasingOrOwnershipStartDate="
				+ leasingOrOwnershipStartDate + ", leasingOrOwnershipEndDate="
				+ leasingOrOwnershipEndDate + "]";
	}
	

}
