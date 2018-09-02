package com.emarket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@MappedSuperclass
public abstract class AuditInfo {
	public AuditInfo() {
		this.createdOn = new Date();
		this.createdBy = "system";
		this.deleted = false;
	}

	@NotNull(message = "The created on must not be null")
	@Column(name = "created_on", updatable = false, nullable = false)
	@CreatedBy
	private Date createdOn;

	@NotNull(message = "The created by must not be null")
	@Column(name = "created_by", updatable = false , nullable = false)
	@CreatedDate
	private String createdBy;

	@Column(name = "updated_on")
	@LastModifiedDate
	private Date updatedOn;

	@Column(name = "updated_by")
	@LastModifiedBy
	private String updatedBy;

	@JsonIgnore
	private boolean deleted;

	@JsonInclude(value = Include.NON_NULL)
	private Date deletedOn;

	@JsonInclude(value = Include.NON_NULL)
	private String deletedBy;

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@PrePersist
	public void prePersist() {
		this.createdOn = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedOn = new Date();
	}
}
