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
@Table(name = "ng_nts_service_usage_rates")
public class ServiceUsageRate extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -379438260367340798L;
	@ManyToOne
	@JoinColumn(name = "compound_id", referencedColumnName = "recid")
	private Compound compound;
	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "recid")
	private Service service;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private Long id;
	@Column(name = "service_name")
	private String serviceName;
	@Column(name = "usage_ammount_from")
	private Double usageAmmountFrom;
	@Column(name = "usage_ammount_to")
	private Double usageAmmountTo;
	@Column(name = "unit_price")
	private Double unitPrice;

	@Override
	public Long getId() {

		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Double getUsageAmmountFrom() {
		return usageAmmountFrom;
	}

	public void setUsageAmmountFrom(Double usageAmmountFrom) {
		this.usageAmmountFrom = usageAmmountFrom;
	}

	public Double getUsageAmmountTo() {
		return usageAmmountTo;
	}

	public void setUsageAmmountTo(Double usageAmmountTo) {
		this.usageAmmountTo = usageAmmountTo;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	public Compound getCompound() {
		return compound;
	}

	public void setCompound(Compound compound) {
		this.compound = compound;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "ServiceUsageRate [compound=" + compound + ", service="
				+ service + ", id=" + id + ", serviceName=" + serviceName
				+ ", usageAmmountFrom=" + usageAmmountFrom
				+ ", usageAmmountTo=" + usageAmmountTo + ", unitPrice="
				+ unitPrice + "]";
	}

	


	

}
