package tests;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class StyleElement {
	
	protected Document DOM;
	protected Element element;
	
	public StyleElement(Document DOM, StyleElementTag tag){
		this.DOM = DOM;
		this.element = DOM.createElement(StyleElementTag.getTagOf(tag));
		createAllAttributes();
	}
	
	protected abstract void createAllAttributes();
	
	public Element getElement(){
		return this.element;
	}

}
