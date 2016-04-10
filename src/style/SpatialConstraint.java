package style;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class SpatialConstraint extends StyleElement{
	
	private Attr id;
	private Attr type;
	private Attr direction;
	private Attr offset;
	private Attr xconnectorAttribute;
	private Attr priority;
	
	private ConstraintConnector xconnector;
	
	private LinkedList<Bind> bindings = new LinkedList<Bind>();
	
	public SpatialConstraint(Document DOM, String id){
		super(DOM, StyleElementTag.SPATIAL_CONSTRAINT);
		this.id.setValue(id);
		this.element.setAttributeNode(this.id);
		this.element.setIdAttributeNode(this.id, true);
	}
	
	@Override
	protected void createAllAttributes(){
		this.id = DOM.createAttribute("id");
		this.type = DOM.createAttribute("type");
		this.direction = DOM.createAttribute("direction");
		this.offset = DOM.createAttribute("offset");
		this.xconnectorAttribute = DOM.createAttribute("xconnector");
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
	
	private void setXConnectorAttribute(String value){
		this.xconnectorAttribute.setValue(value);
		this.element.setAttributeNode(this.xconnectorAttribute);
	}
	
	public String getXConnectorAttribute(){
		return this.xconnectorAttribute.getValue();
	}
	
	public void setPriority(String priority){
		this.priority.setValue(priority);
		this.element.setAttributeNode(this.priority);
	}
	
	public void setXConnector(ConstraintConnector connector){
		this.xconnector = connector;
		setXConnectorAttribute(connector.getId());
	}
	
	public ConstraintConnector getXConnector(){
		return this.xconnector;
	}

}
