package com.ntgclarity.smartcompound.common.entity;

import java.io.Serializable;




//import java.util.Date;

//import java.sql.Timestamp;
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
@Table(name = "ng_nts_tickets")
public class Ticket extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "compound_id", referencedColumnName = "recid")
	private Compound compoundId;
	
	@ManyToOne
	@JoinColumn(name = "channel_lookup_id", referencedColumnName = "recid")
	private Lookup channelLookupId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private Long id;
	
	@Column(name = "ticket_subject")
	private String ticketSubject;
	
	@Column(name = "problem_date")
	private Date problemDate;
	
	@Column(name = "last_status")
	private String lastStatus;
	
	@Column(name = "feedback")
	private String feedback;
	// @Column(name="ticket_id")
	// private Integer ticketId;

	@Column(name = "open_date")
	private Date openDate;

	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "recid")
	private Service serviceId;
	
	@Column(name = "service_name")
	private String serviceName;

	@ManyToOne
	@JoinColumn(name = "related_tenant_id", referencedColumnName = "recid")
	private Tenant relatedTenantId;

	@ManyToOne
	@JoinColumn(name = "opened_by", referencedColumnName = "recid")
	private Employee openedBy;

	@Column(name = "description")
	private String description;

	@Column(name = "severity")
	private Integer severity;

	@ManyToOne
	@JoinColumn(name = "facility_id", referencedColumnName = "recid")
	private Facility facilityId;

	@Column(name = "channel")
	private String channel;

	@ManyToOne
	@JoinColumn(name = "assigned_group_id", referencedColumnName="recid")
	private Group assignedGroupId;

	@Column(name = "rate")
	private String rate;
	
	@Column(name = "group_name")
	private String groupName;

	public Facility getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Facility facilityId) {
		this.facilityId = facilityId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public Compound getCompound() {
		return compoundId;
	}

	public void setCompound(Compound compoundId) {
		this.compoundId = compoundId;
	}

	public Compound getCompoundId() {
		return compoundId;
	}

	public void setCompoundId(Compound compoundId) {
		this.compoundId = compoundId;
	}

	public String getTicketSubject() {
		return ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public Date getProblemDate() {
		return problemDate;
	}

	public void setProblemDate(Date problemDate) {
		this.problemDate = problemDate;
	}

	public String getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Tenant getRelatedTenantId() {
		return relatedTenantId;
	}

	public void setRelatedTenantId(Tenant relatedTenantId) {
		this.relatedTenantId = relatedTenantId;
	}

	public Employee getOpenedBy() {
		return openedBy;
	}

	public void setOpenedBy(Employee openedBy) {
		this.openedBy = openedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public Group getAssignedGroupId() {
		return assignedGroupId;
	}

	public void setAssignedGroupId(Group assignedGroupId) {
		this.assignedGroupId = assignedGroupId;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Lookup getChannelLookupId() {
		return channelLookupId;
	}

	public void setChannelLookupId(Lookup channelLookupId) {
		this.channelLookupId = channelLookupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Ticket [compoundId=" + compoundId + ", channelLookupId="
				+ channelLookupId + ", id=" + id + ", ticketSubject="
				+ ticketSubject + ", problemDate=" + problemDate
				+ ", lastStatus=" + lastStatus + ", feedback=" + feedback
				+ ", openDate=" + openDate + ", serviceId=" + serviceId
				+ ", serviceName=" + serviceName + ", relatedTenantId="
				+ relatedTenantId + ", openedBy=" + openedBy + ", description="
				+ description + ", severity=" + severity + ", facilityId="
				+ facilityId + ", channel=" + channel + ", assignedGroupId="
				+ assignedGroupId + ", rate=" + rate + ", groupName="
				+ groupName + "]";
	}



}
