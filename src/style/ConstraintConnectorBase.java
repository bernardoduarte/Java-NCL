package style;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class ConstraintConnectorBase extends StyleElement {
	
	private Attr alias;
	private Attr documentURI;
	
	

	public ConstraintConnectorBase(Document DOM, String alias, String documentURI) {
		super(DOM, StyleElementTag.CONSTRAINT_CONNECTOR_BASE);
		this.alias.setValue(alias);
		this.element.setAttributeNode(this.alias);
		this.documentURI.setValue(documentURI);
		this.element.setAttributeNode(this.documentURI);
	}

	@Override
	protected void createAllAttributes() {
		this.alias = DOM.createAttribute("alias");
		this.documentURI = DOM.createAttribute("documentURI");
	}
	
	public void setAlias(String alias){
		this.alias.setValue(alias);
	}
	
	public String getAlias(){
		return this.alias.getValue();
	}
	
	public void setDocumentURI(String URI){
		this.documentURI.setValue(URI);
	}
	
	public String getDocumentURI(){
		return this.documentURI.getValue();
	}

}
