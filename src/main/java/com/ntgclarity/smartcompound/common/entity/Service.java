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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Entity
@Table(name = "ng_nts_services")
public class Service extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="ng_nts_services_recid_seq")
	@SequenceGenerator(name="ng_nts_services_recid_seq", sequenceName="ng_nts_services_recid_seq")
	@Column(name = "recid")
	private Long id;
	@Column(name="service_name")
	private String serviceName;
	@Column(name="description")
	private String description;
	@Column(name="is_active")
	private Integer isActive;
	@Column(name="severity")
	private Integer severity;
	@Column(name="flat_or_usage")
	private String flatOrUsage;
	@Column (name="estimated_delivery_days")
	private Integer estimatedDeliveryDays;
	@Column(name="nrc")
	private Integer nrc;
	@Column(name="mrc")
	private Integer mrc;
	@Column(name="installation_price") 
	private Double installationPrice;
	@Column(name="is_prepaid")
	private Integer isPrepaid;
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="measuring_unit")
	private String measuringUnit;
	@ManyToOne
	@JoinColumn(name = "compound_id", referencedColumnName = "recid")
	private Compound compound;
	@ManyToOne
	@JoinColumn(name = "measuring_unit_lookup_id", referencedColumnName = "recid")
	private Lookup measuringUnitLookupId;
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
		
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public String getFlatOrUsage() {
		return flatOrUsage;
	}

	public void setFlatOrUsage(String flatOrUsage) {
		this.flatOrUsage = flatOrUsage;
	}

	public Integer getEstimatedDeliveryDays() {
		return estimatedDeliveryDays;
	}

	public void setEstimatedDeliveryDays(Integer estimatedDeliveryDays) {
		this.estimatedDeliveryDays = estimatedDeliveryDays;
	}

	public Integer getNrc() {
		return nrc;
	}

	public void setNrc(Integer nrc) {
		this.nrc = nrc;
	}

	public Integer getMrc() {
		return mrc;
	}

	public void setMrc(Integer mrc) {
		this.mrc = mrc;
	}

	public Double getInstallationPrice() {
		return installationPrice;
	}

	public void setInstallationPrice(Double installationPrice) {
		this.installationPrice = installationPrice;
	}

	public Integer getIsPrepaid() {
		return isPrepaid;
	}

	public void setIsPrepaid(Integer isPrepared) {
		this.isPrepaid = isPrepared;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	public Lookup getMeasuringUnitLookupId() {
		return measuringUnitLookupId;
	}

	public void setMeasuringUnitLookupId(Lookup measuringUnitLookupId) {
		this.measuringUnitLookupId = measuringUnitLookupId;
	}

	public Compound getCompound() {
		return compound;
	}

	public void setCompound(Compound compound) {
		this.compound = compound;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName
				+ ", description=" + description + ", isActive=" + isActive
				+ ", severity=" + severity + ", flatOrUsage=" + flatOrUsage
				+ ", estimatedDeliveryDays=" + estimatedDeliveryDays + ", nrc="
				+ nrc + ", mrc=" + mrc + ", installationPrice="
				+ installationPrice + ", isPrepared=" + isPrepaid
				+ ", creationDate=" + creationDate + ", measuringUnit="
				+ measuringUnit + ", compound=" + compound + "]";
	}
	

}
