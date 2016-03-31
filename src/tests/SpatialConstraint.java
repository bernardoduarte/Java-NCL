package tests;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class SpatialConstraint extends StyleElement{
	
	private Attr id;
	private Attr type;
	private Attr direction;
	private Attr offset;
	private Attr xconnector;
	private Attr priority;
	
	private LinkedList<Bind> bindings = new LinkedList<Bind>();
	
	public SpatialConstraint(Document DOM, String id){
		super(DOM, "spatialConstraint");
		this.id.setValue(id);
		this.element.setAttributeNode(this.id);
	}
	
	protected void createAllAttributes(){
		this.id = DOM.createAttribute("id");
		this.type = DOM.createAttribute("type");
		this.direction = DOM.createAttribute("direction");
		this.offset = DOM.createAttribute("offset");
		this.xconnector = DOM.createAttribute("xconnector");
		this.priority = DOM.createAttribute("priority");
	}
	
	public void appendBinding(Bind newBind){
		boolean hasBind = false;
		for(Bind currentBind: bindings){
			if(currentBind == newBind){
				hasBind = true;
			}
		}
		if(!hasBind){
			this.bindings.push(newBind);
			this.element.appendChild(newBind.getElement());
		}
	}
	
	public void setType(String type){
		this.type.setValue(type);
		this.element.setAttributeNode(this.type);
	}
	
	public String getType(){
		return this.type.getValue();
	}
	
	public void setDirection(String direction){
		this.direction.setValue(direction);
		this.element.setAttributeNode(this.direction);
	}
	
	public String getDirection(){
		return this.direction.getValue();
	}
	
	public void setOffset(int offset){
		this.offset.setValue(String.valueOf(offset));
		this.element.setAttributeNode(this.offset);
	}
	
	public int getOffset(){
		return Integer.parseInt(this.direction.getValue());
	}
	
	public void setXconnector(String value){
		this.xconnector.setValue(value);
		this.element.setAttributeNode(this.xconnector);
	}
	
	public String getXconnector(){
		return this.xconnector.getValue();
	}
	
	public void setPriority(String priority){
		this.priority.setValue(priority);
		this.element.setAttributeNode(this.priority);
	}

}
