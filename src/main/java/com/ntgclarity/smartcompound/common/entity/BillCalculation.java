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
//@Table(name = "BILL_CALCULATION")
public class BillCalculation extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "recid")
	private Long id;
	@Column(name = "service_id")
	private Long service;
	@Column(name = "order_id")
	private Long order;
	@Column(name = "calculation_date")
	private Date calculationDate;
	@Column(name = "calculation_month_and_year")
	private Date calculationMonthAndYear;
	@Column(name = "previous_meter_reading")
	private Double previousMeterReading;
	@Column(name = "current_meter_reading")
	private Double currentMeterReading;
	@Column(name = "insallation_value")
	private Double installationValue;
	@Column(name = "nrc_value")
	private Double nrcValue;
	@Column(name = "mrc_value")
	private Double mrcValue;
	@Column(name = "usage_amount")
	private Double usageAmount;
	@Column(name = "usage_value")
	private Double usageValue;
	@Column(name = "calculation_base")
	private String calculationBase;
	@Column(name = "description")
	private String description;
	@Column(name = "calculated_by")
	private String calculatedBy;
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

	public Date getCalculationDate() {
		return calculationDate;
	}

	public void setCalculationDate(Date calculationDate) {
		this.calculationDate = calculationDate;
	}

	public Date getCalculationMonthAndYear() {
		return calculationMonthAndYear;
	}

	public void setCalculationMonthAndYear(Date calculationMonthAndYear) {
		this.calculationMonthAndYear = calculationMonthAndYear;
	}

	public Double getPreviousMeterReading() {
		return previousMeterReading;
	}

	public void setPreviousMeterReading(Double previousMeterReading) {
		this.previousMeterReading = previousMeterReading;
	}

	public Double getCurrentMeterReading() {
		return currentMeterReading;
	}

	public void setCurrentMeterReading(Double currentMeterReading) {
		this.currentMeterReading = currentMeterReading;
	}

	public Double getInstallationValue() {
		return installationValue;
	}

	public void setInstallationValue(Double installationValue) {
		this.installationValue = installationValue;
	}

	public Double getNrcValue() {
		return nrcValue;
	}

	public void setNrcValue(Double nrcValue) {
		this.nrcValue = nrcValue;
	}

	public Double getMrcValue() {
		return mrcValue;
	}

	public void setMrcValue(Double mrcValue) {
		this.mrcValue = mrcValue;
	}

	public Double getUsageAmount() {
		return usageAmount;
	}

	public void setUsageAmount(Double usageAmount) {
		this.usageAmount = usageAmount;
	}

	public Double getUsageValue() {
		return usageValue;
	}

	public void setUsageValue(Double usageValue) {
		this.usageValue = usageValue;
	}

	public String getCalculationBase() {
		return calculationBase;
	}

	public void setCalculationBase(String calculationBase) {
		this.calculationBase = calculationBase;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCalculatedBy() {
		return calculatedBy;
	}

	public void setCalculatedBy(String calculatedBy) {
		this.calculatedBy = calculatedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getService() {
		return service;
	}

	public void setService(Long service) {
		this.service = service;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Compound getCompound() {
		return compound;
	}

	public void setCompound(Compound compound) {
		this.compound = compound;
	}

	@Override
	public String toString() {
		return "BillCalculation [id=" + id + ", service=" + service
				+ ", order=" + order + ", calculationDate="
				+ calculationDate + ", calculationMonthAndYear="
				+ calculationMonthAndYear + ", previousMeterReading="
				+ previousMeterReading + ", currentMeterReading="
				+ currentMeterReading + ", installationValue="
				+ installationValue + ", nrcValue=" + nrcValue + ", mrcValue="
				+ mrcValue + ", usageAmount=" + usageAmount + ", usageValue="
				+ usageValue + ", calculationBase=" + calculationBase
				+ ", description=" + description + ", calculatedBy="
				+ calculatedBy + ", compound=" + compound + "]";
	}



	

}
