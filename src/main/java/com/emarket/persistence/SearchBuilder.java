package com.emarket.persistence;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

import com.emarket.object.requestbody.CriteriaGroupManagedResource;
import com.emarket.object.requestbody.CriteriaManagedResource;
import com.emarket.object.requestbody.SearchCriteria;

public class SearchBuilder<T>{
	
    private final List<SearchCriteria> params;
    
    public SearchBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
     
	public SearchBuilder<T> createSearchBuilderFromParams(CriteriaManagedResource criteriaManagedResource) {
    		if(criteriaManagedResource != null && criteriaManagedResource instanceof CriteriaGroupManagedResource) {
    			CriteriaGroupManagedResource criteriaGroupManagedResource = (CriteriaGroupManagedResource) criteriaManagedResource;
    			List<CriteriaManagedResource> criterias = criteriaGroupManagedResource.getCriterias();
    			criterias.forEach(criteria -> {
    				if(criteria instanceof SearchCriteria) {
    					SearchCriteria searchCriteria = (SearchCriteria) criteria;
    					params.add(searchCriteria);
    				}
    			});
    		}
    		return this;
    }
 
    public SearchBuilder<T> with(String field, String operator, Object value) {
    		SearchCriteria searchCriteria = new SearchCriteria();
    		searchCriteria.setField(field);
    		searchCriteria.setOperator(operator);
    		searchCriteria.setValue(value);
        params.add(searchCriteria);
        return this;
    }
 
    public Specification<T> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<T>> specs = new ArrayList<Specification<T>>();
        for (SearchCriteria param : params) {
            specs.add(new CommonSpecification<T>(param));
        }
 
        Specification<T> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}


