package tests;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Bind extends StyleElement{
	
	private Element componentElement;
	
	private Attr role;
	private Attr component;
	private Attr bindInterface;
	
	public Bind(Document DOM){
		super(DOM, "bind");
	}
	
	protected void createAllAttributes(){
		this.role = DOM.createAttribute("role");
		this.component = DOM.createAttribute("component");
		this.bindInterface = DOM.createAttribute("interface");
	}
	
	public void setRole(String role){
		this.role.setValue(role);
		this.element.setAttributeNode(this.role);
	}
	
	public String getRole(){
		return this.role.getValue();
	}
	
	public void setComponent(Element component){
		this.componentElement = component;
		this.component.setValue(component.getAttribute("id"));
		this.element.setAttributeNode(this.component);
	}
	
	public Element getComponent(){
		return this.componentElement;
	}
	
	public void setInterface(String value){
		this.bindInterface.setValue(value);
		this.element.setAttributeNode(this.bindInterface);
	}
	
	public String getInterface(){
		return this.bindInterface.getValue();
	}

}
