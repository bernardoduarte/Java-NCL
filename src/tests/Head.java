package tests;

import org.w3c.dom.Document;

public class Head extends StyleElement {
	
	public Head(Document DOM){
		super(DOM, StyleElementTag.HEAD);
	}
	
	@Override
	protected void createAllAttributes() {
		
	}

}
