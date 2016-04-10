package style;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class Layout extends StyleElement{
	
	private Attr id;
	
	private Head head;
	private Body body;
	
	public Layout(Document DOM, String id){
		super(DOM, StyleElementTag.LAYOUT);
		this.id.setValue(id);
		this.element.setAttributeNode(this.id);
		this.element.setIdAttributeNode(this.id, true);
	}
	
	@Override
	protected void createAllAttributes(){
		this.id = DOM.createAttribute("id");
	}
	
	public void setId(String id){
		this.id.setValue(id);
	}
	
	public String getId(){
		return this.id.getValue();
	}
	
	public void setHead(Head head){
		this.head = head;
		this.element.appendChild(this.head.getElement());
	}
	
	public Head getHead(){
		return this.head;
	}
	
	public void setBody(Body body){
		this.body = body;
		this.element.appendChild(this.body.getElement());
	}
	
	public Body getBody(){
		return this.body;
	}

}
