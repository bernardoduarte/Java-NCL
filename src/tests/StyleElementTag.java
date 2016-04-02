package tests;

public enum StyleElementTag {
	
	LAYOUT,
	HEAD,//TODO
	BODY,
	CONSTRAINT_CONNECTOR_BASE,//TODO
	CONSTRAINT_CONNECTOR,//TODO
	CONNECTOR_PARAM,
	COMPOUND_STATEMENT,
	ASSESSMENT_STATEMENT,
	ATTRIBUTE_ASSESSMENT,
	VALUE_ASSESSMENT,
	CONTAINER,
	FORMAT,
	SPATIAL_CONSTRAINT,//TODO
	BIND,//TODO
	BIND_PARAM,//TODO
	ITEM;
	
	public static final String getTagOf(StyleElementTag tag){
		switch(tag){
		case LAYOUT:
			return "layout";
			
		case HEAD:
			return "head";
			
		case BODY:
			return "body";
			
		case CONSTRAINT_CONNECTOR_BASE:
			return "constraintConnectorBase";
			
		case CONSTRAINT_CONNECTOR:
			return "constraintConnector";
			
		case CONNECTOR_PARAM:
			return "connectorParam";
			
		case COMPOUND_STATEMENT:
			return "compoundStatement";
			
		case ASSESSMENT_STATEMENT:
			return "assessmentStatement";
			
		case ATTRIBUTE_ASSESSMENT:
			return "attributeAssessment";
			
		case VALUE_ASSESSMENT:
			return "valueAssessment";
			
		case CONTAINER:
			return "container";
			
		case FORMAT:
			return "format";
			
		case SPATIAL_CONSTRAINT:
			return "spatialConstraint";
			
		case BIND:
			return "bind";
			
		case BIND_PARAM:
			return "bindParam";
			
		case ITEM:
			return "item";
			
		default :
			System.out.println("Invalid StyleElementTag value of: "+tag);
			return null;
		}
	}
}
