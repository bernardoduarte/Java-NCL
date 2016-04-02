package tests;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class ValueAssessment extends StyleElement {

	private Attr value;
	
	public ValueAssessment(Document DOM){
		super(DOM, StyleElementTag.VALUE_ASSESSMENT);
	}
	
	@Override
	protected void createAllAttributes() {
		this.value = DOM.createAttribute("value");
	}
	
	public void setValue(String value){
		this.value.setValue(value);
		this.element.setAttributeNode(this.value);
	}
	
	public String getValue(){
		return this.value.getValue();
	}

}
