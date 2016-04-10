package style;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class ConstraintConnector extends StyleElement {
	
	private Attr id;
	
	private ConnectorParam connectorParam;
	
	private LinkedList<StyleElement> statements = new LinkedList<StyleElement>();
	
	public ConstraintConnector(Document DOM, String id){
		super(DOM, StyleElementTag.CONSTRAINT_CONNECTOR);
		this.id.setValue(id);
		this.element.setAttributeNode(this.id);
		this.element.setIdAttributeNode(this.id, true);
	}

	@Override
	protected void createAllAttributes() {
		this.id = DOM.createAttribute("id");
	}
	
	public void appendChild(StyleElement newChild){
		boolean hasChild = false;
		for(StyleElement currentChild: statements){
			if(currentChild == newChild){
				System.out.println("Child "+newChild.getElement().getTagName()+" "+newChild.getElement().getAttribute("id")+" Already Exists.");
				hasChild = true;
			}
		}
		if(!hasChild){
			statements.push(newChild);
			this.element.appendChild(newChild.getElement());
		}
	}
	
	public void setId(String id){
		this.id.setValue(id);
	}
	
	public String getId(){
		return this.id.getValue();
	}
	
	public void setConnectorParam(String name){
		this.connectorParam = new ConnectorParam(DOM, name);
		this.element.appendChild(this.connectorParam.getElement());
	}
	
	public ConnectorParam getConnectorParam(){
		return this.connectorParam;
	}

}
