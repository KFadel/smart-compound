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
@Table(name = "ng_nts_services")
public class Service extends BaseEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rec_id")
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
	@Column(name="intallation_price")
	private Double installationPrice;
	@Column(name="is_prepared")
	private Integer isPrepared;
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="measuring_unit")
	private String measuringUnit;
	@ManyToOne
	@JoinColumn(name = "compound_id", referencedColumnName = "rec_id")
	private Compound compoundId;
	@ManyToOne
	@JoinColumn(name = "measuring_unit_lookup_id", referencedColumnName = "rec_id")
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

	public Integer getIsPrepared() {
		return isPrepared;
	}

	public void setIsPrepared(Integer isPrepared) {
		this.isPrepared = isPrepared;
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

	public Compound getCompoundId() {
		return compoundId;
	}

	public void setCompoundId(Compound compoundId) {
		this.compoundId = compoundId;
	}

	public Lookup getMeasuringUnitLookupId() {
		return measuringUnitLookupId;
	}

	public void setMeasuringUnitLookupId(Lookup measuringUnitLookupId) {
		this.measuringUnitLookupId = measuringUnitLookupId;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName
				+ ", description=" + description + ", isActive=" + isActive
				+ ", severity=" + severity + ", flatOrUsage=" + flatOrUsage
				+ ", estimatedDeliveryDays=" + estimatedDeliveryDays + ", nrc="
				+ nrc + ", mrc=" + mrc + ", installationPrice="
				+ installationPrice + ", isPrepared=" + isPrepared
				+ ", creationDate=" + creationDate + ", measuringUnit="
				+ measuringUnit + ", compoundId=" + compoundId + "]";
	}
	

}
