package com.emarket.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.emarket.constant.CriteriaOperator;
import com.emarket.object.requestbody.SearchCriteria;
import com.emarket.util.StringUtil;

public class CommonSpecification<T> implements Specification<T> {
	
	private static final long serialVersionUID = -7060802956305635385L;
	private SearchCriteria criteria;
	
	public CommonSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		String operator = criteria.getOperator();
		CriteriaOperator criteriaOperator = CriteriaOperator.fromString(operator);
		
		if(criteriaOperator == CriteriaOperator.greater_than) {
            return builder.greaterThan(
                    root.<String> get(criteria.getField()), criteria.getValue().toString());
		} else if(criteriaOperator == CriteriaOperator.greater_than_or_equal) {
            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getField()), criteria.getValue().toString());
		} else if(criteriaOperator == CriteriaOperator.lesser_than) {
            return builder.lessThan(
                    root.<String> get(criteria.getField()), criteria.getValue().toString());
		} else if(criteriaOperator == CriteriaOperator.lesser_than_or_equal) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getField()), criteria.getValue().toString());
		} else if(criteriaOperator == CriteriaOperator.like) {
            return builder.like(
                    root.<String>get(criteria.getField()), "%" + criteria.getValue() + "%");
		} else if(criteriaOperator == CriteriaOperator.equal) {
            return builder.equal(root.get(criteria.getField()), criteria.getValue());
		} else if(criteriaOperator == CriteriaOperator.not_equal) {
            return builder.notEqual(root.get(criteria.getField()), criteria.getValue());
		} else if(criteriaOperator == CriteriaOperator.not_like) {
            return builder.notLike(
                    root.<String>get(criteria.getField()), "%" + criteria.getValue() + "%");
		} else if(criteriaOperator == CriteriaOperator.is_not_null) {
            return builder.isNotNull(root.get(criteria.getField()));
		} else if(criteriaOperator == CriteriaOperator.is_null) {
            return builder.isNull(root.get(criteria.getField()));
		} else if(criteriaOperator == CriteriaOperator.in) {
			List<String> valueList = StringUtil.listStringDelimited(criteria.getValue().toString(), ",");
		}       
		
        return null;
	}

}
