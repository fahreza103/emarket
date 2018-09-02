package com.emarket.constant;

public enum CriteriaOperator {
	not_in, in, not_equal, equal, greater_than, greater_than_or_equal, lesser_than, lesser_than_or_equal, not_like, like, is_null, is_not_null, is_empty, is_not_empty;

	public static CriteriaOperator fromString(String text) {
		switch (text) {
		case "notIn":
		case "not_in":
			return CriteriaOperator.not_in;
		case "in":
			return CriteriaOperator.in;
		case "notEq":
		case "not_equal":
			return CriteriaOperator.not_equal;
		case "eq":
		case "equal":
			return CriteriaOperator.equal;
		case ">":
		case "greater_than":
			return CriteriaOperator.greater_than;
		case ">=":
		case "greater_than_or_equal":
			return CriteriaOperator.greater_than_or_equal;
		case "<":
		case "lesser_than":
			return CriteriaOperator.lesser_than;
		case "<=":
		case "lesser_than_or_equal":
			return CriteriaOperator.lesser_than_or_equal;
		case "like":
			return CriteriaOperator.like;
		case "notLike":
		case "not_like":
			return CriteriaOperator.not_like;
		case "is_null":
		case "isNull":
			return CriteriaOperator.is_null;
		case "isNotNull":
			return CriteriaOperator.is_not_null;
		case "isEmpty":
			return CriteriaOperator.is_empty;
		case "isNotEmpty":
			return CriteriaOperator.is_not_empty;
		default:
			throw new RuntimeException(String.format("Invalid search operator: %s", text));

		}
	}

}
