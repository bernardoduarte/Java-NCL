package tests;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class AttributeAssessment extends StyleElement {

	private Attr role;
	private Attr eventType;
	private Attr attributeType;
	
	public AttributeAssessment(Document DOM) {
		super(DOM, StyleElementTag.ATTRIBUTE_ASSESSMENT);
	}

	@Override
	protected void createAllAttributes() {
		this.role = DOM.createAttribute("role");
		this.eventType = DOM.createAttribute("eventType");
		this.attributeType = DOM.createAttribute("attributeType");
	}
	
	public void setRole(String role){
		this.role.setValue(role);
		this.element.setAttributeNode(this.role);
	}
	
	public String getRole(){
		return this.role.getValue();
	}
	
	public void setEventType(String eventType){
		this.eventType.setValue(eventType);
		this.element.setAttributeNode(this.eventType);
	}
	
	public String getEventType(){
		return this.eventType.getValue();
	}
	
	public void setAttributeType(String attributeType){
		this.attributeType.setValue(attributeType);
		this.element.setAttributeNode(this.attributeType);
	}
	
	public String getAttributeType(){
		return this.attributeType.getValue();
	}

}
