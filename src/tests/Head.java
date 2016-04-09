package tests;

import java.util.LinkedList;

import org.w3c.dom.Document;

public class Head extends StyleElement {
	
	private LinkedList<ConstraintConnector> connectors = new LinkedList<ConstraintConnector>();
	
	private LinkedList<ConstraintConnectorBase> connectorBases = new LinkedList<ConstraintConnectorBase>();
	
	private LinkedList<StyleElement> children = new LinkedList<StyleElement>();
	
	public Head(Document DOM){
		super(DOM, StyleElementTag.HEAD);
	}
	
	@Override
	protected void createAllAttributes() {
		
	}
	
	private void appendChild(StyleElement newChild){
		this.children.push(newChild);
		this.element.appendChild(newChild.getElement());
	}
	
	public void addConstraintConnector(ConstraintConnector newConnector){
		boolean hasConnector = false;
		for(ConstraintConnector currentConnector: connectors){
			if(currentConnector == newConnector){
				hasConnector = true;
			}
		}
		if(!hasConnector){
			this.connectors.push(newConnector);
			appendChild(newConnector);
		}
	}
	
	public void addConstraintConnectorBase(ConstraintConnectorBase newConnectorBase){
		boolean hasConnector = false;
		for(ConstraintConnectorBase currentConnector: connectorBases){
			if(currentConnector == newConnectorBase){
				hasConnector = true;
			}
		}
		if(!hasConnector){
			this.connectorBases.push(newConnectorBase);
			appendChild(newConnectorBase);
		}
	}

}
