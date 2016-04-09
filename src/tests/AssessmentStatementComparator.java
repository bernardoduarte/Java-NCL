package tests;

public enum AssessmentStatementComparator {
	
	EQUAL_TO,
	NOT_EQUAL_TO,
	GREATER_THAN,
	LESS_THAN,
	GREATER_THAN_OR_EQUAL_TO,
	LESS_THAN_OR_EQUAL_TO;
	
	public static final String getComparatorOf(AssessmentStatementComparator comparator){
		switch(comparator){
		case EQUAL_TO:
			return "eq";
		case NOT_EQUAL_TO:
			return "ne";
		case GREATER_THAN:
			return "gt";
		case LESS_THAN:
			return "lt";
		case GREATER_THAN_OR_EQUAL_TO:
			return "gte";
		case LESS_THAN_OR_EQUAL_TO:
			return "lte";
		default:
			System.out.println("Invalid AssessmentStatementComparator value of: "+comparator);
			return null;
		}
	}

}
