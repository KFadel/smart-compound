package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

//@Entity
@Table(name = "EMPLOYEE")
public class BillDetails extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "recid")
	private Long id;
	@Column(name="service_id")
	private Long serviceId;
	@Column (name="nrc")
	private Double nrc;
	@Column(name="mrc")
	private Double mrc;
	@Column (name="installation")
	private Double installation;
	@Column (name="total_amount")
	private Double totalAmount;
	@ManyToOne
	@JoinColumn(name ="compound_id" , referencedColumnName="recid")
	private Compound compound;
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
		
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Double getNrc() {
		return nrc;
	}

	public void setNrc(Double nrc) {
		this.nrc = nrc;
	}

	public Double getMrc() {
		return mrc;
	}

	public void setMrc(Double mrc) {
		this.mrc = mrc;
	}

	public Double getInstallation() {
		return installation;
	}

	public void setInstallation(Double installation) {
		this.installation = installation;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Compound getCompound() {
		return compound;
	}

	public void setCompound(Compound compound) {
		this.compound = compound;
	}

	@Override
	public String toString() {
		return "BillDetails [id=" + id + ", serviceId=" + serviceId + ", nrc="
				+ nrc + ", mrc=" + mrc + ", installation=" + installation
				+ ", totalAmount=" + totalAmount + ", compound=" + compound
				+ "]";
	}
	


	
	

}
