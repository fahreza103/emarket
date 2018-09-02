package com.emarket.object.requestbody;

public class SearchCriteria extends CriteriaManagedResource {

    private String field;
    private String operator;
    private Object value;
    
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
    
    
	@Override
	public boolean isEmpty() {
		return value == null && operator == null && value == null;
	}
    

}
