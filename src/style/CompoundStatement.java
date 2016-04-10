package style;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class CompoundStatement extends StyleElement {

	private Attr operator;
	
	private LinkedList<StyleElement> children = new LinkedList<StyleElement>();
	
	public CompoundStatement(Document DOM, String operator){
		super(DOM, StyleElementTag.COMPOUND_STATEMENT);
		this.operator.setValue(operator);
		this.element.setAttributeNode(this.operator);
	}
	
	@Override
	protected void createAllAttributes() {
		this.operator = DOM.createAttribute("operator");
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
	
	public void setOperator(String operator){
		this.operator.setValue(operator);
	}
	
	public String getOperator(){
		return this.operator.getValue();
	}

}
