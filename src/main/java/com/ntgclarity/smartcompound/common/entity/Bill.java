package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

//@Entity
//@Table(name = "BILL")
public class Bill extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "recid")
	private Long id;
	@Column(name = "bill_number")
	private Long billNumber;
	@Column(name = "issue_date")
	private Date issueDate;
	@Column(name = "bill_from")
	private Date billFrom;
	@Column(name = "bill_to")
	private Date billTo;
	@Column(name = "tenant_id")
	private Long tenantId;
	@Column(name = "total_amount")
	private Double totalAmount;
	@Column(name = "collected")
	private Boolean collected;
	@Column(name = "collection_date")
	private Date collectionDate;
	@Column(name = "payment_method")
	private String collectionMethod;
	@Column(name = "collected_by")
	private String collectedBy;
	@ManyToOne
	@JoinColumn(name ="compound_id" , referencedColumnName="recid")
	private Compound compound;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public Long getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getBillFrom() {
		return billFrom;
	}

	public void setBillFrom(Date billFrom) {
		this.billFrom = billFrom;
	}

	public Date getBillTo() {
		return billTo;
	}

	public void setBillTo(Date billTo) {
		this.billTo = billTo;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Boolean getCollected() {
		return collected;
	}

	public void setCollected(Boolean collected) {
		this.collected = collected;
	}

	public Date getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCollectionMethod() {
		return collectionMethod;
	}

	public void setCollectionMethod(String collectionMethod) {
		this.collectionMethod = collectionMethod;
	}

	public String getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
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
		return "Bill [id=" + id + ", billNumber=" + billNumber + ", issueDate="
				+ issueDate + ", billFrom=" + billFrom + ", billTo=" + billTo
				+ ", tenantId=" + tenantId + ", totalAmount=" + totalAmount
				+ ", collected=" + collected + ", collectionDate="
				+ collectionDate + ", collectionMethod=" + collectionMethod
				+ ", collectedBy=" + collectedBy + ", compound=" + compound
				+ "]";
	}

	

	

}
