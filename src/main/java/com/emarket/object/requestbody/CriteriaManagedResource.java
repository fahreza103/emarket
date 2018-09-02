package com.emarket.object.requestbody;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "group", defaultImpl = SearchCriteria.class)
@JsonSubTypes({ @Type(value = AndCriteriaManagedResource.class, name = "AND"),
		@Type(value = OrCriteriaManagedResource.class, name = "OR") })
public abstract class CriteriaManagedResource {

	public boolean isEmpty() {
		return false;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
