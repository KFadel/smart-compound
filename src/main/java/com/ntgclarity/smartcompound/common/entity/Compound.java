package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Entity
@Table(name = "ng_nts_compounds")
public class Compound extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="ng_nts_compounds_recid_seq")
	@SequenceGenerator(name="ng_nts_compounds_recid_seq", sequenceName="ng_nts_compounds_recid_seq")
	@Column(name = "recid")
	private Long id;

	@Column(name = "compound_name")
	private String compoundName;
	@Column(name = "longtude")
	private Double longtude;
	@Column(name = "lattitude")
	private Double lattitude;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	@Column(name = "owner_name")
	private String ownerName;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public String getCompoundName() {
		return compoundName;
	}

	public void setCompoundName(String compoundName) {
		this.compoundName = compoundName;
	}

	public Double getLongtude() {
		return longtude;
	}

	public void setLongtude(Double longtude) {
		this.longtude = longtude;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Compound [id=" + id + ", compoundName=" + compoundName
				+ ", longtude=" + longtude + ", lattitude=" + lattitude
				+ ", country=" + country + ", city=" + city + ", ownerName="
				+ ownerName + "]";
	}

}
