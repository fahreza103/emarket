package com.emarket.object.requestbody;

import java.util.ArrayList;
import java.util.List;


public class CriteriaGroupManagedResource extends CriteriaManagedResource {
	
	public CriteriaGroupManagedResource(String group) {
		this.group = group;
	}

	private String group;

	private List<CriteriaManagedResource> criterias;

	public List<CriteriaManagedResource> getCriterias() {
		if (criterias == null) {
			criterias = new ArrayList<>();
		}
		return criterias;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
