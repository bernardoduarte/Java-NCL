package style;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class Body extends StyleElement {

	private Attr id;
	
	private LinkedList<StyleElement> children = new LinkedList<StyleElement>();
	
	public Body(Document DOM, String id){
		super(DOM, StyleElementTag.BODY);
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
		for(StyleElement currentChild: children){
			if(currentChild == newChild){
				System.out.println("Child "+newChild.getElement().getTagName()+" "+newChild.getElement().getAttribute("id")+" Already Exists.");
				hasChild = true;
			}
		}
		if(!hasChild){
			children.push(newChild);
			this.element.appendChild(newChild.getElement());
		}
	}
	
	public void setId(String id){
		this.id.setValue(id);
	}
	
	public String getId(){
		return this.id.getValue();
	}

}
