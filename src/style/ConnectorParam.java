package style;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class ConnectorParam extends StyleElement {

	private Attr name;
	
	public ConnectorParam(Document DOM, String name) {
		super(DOM, StyleElementTag.CONNECTOR_PARAM);
		this.name.setValue(name);
		this.element.setAttributeNode(this.name);
		this.element.setIdAttributeNode(this.name, true);
	}

	@Override
	protected void createAllAttributes() {
		this.name = DOM.createAttribute("name");
	}
	
	public void setName(String name){
		this.name.setValue(name);
	}
	
	public String getName(){
		return this.name.getValue();
	}

}
