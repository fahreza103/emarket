package com.emarket.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;



@MappedSuperclass
public class Generic extends AuditInfo implements Serializable, CommonEntity {

	private static final long serialVersionUID = 6999480798155659993L;

	public Generic() {
		super();

	}

	public Generic(long id) {
		this();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected long id;

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Generic && this.id > 0) {
			return ((Generic) obj).getId() == this.id;
		}
		return super.equals(obj);
	}

	protected Class<?> getControllerClass() {
		return null;
	}

	@JsonIgnore
	protected Generic getParent() {
		return null;
	}
}
