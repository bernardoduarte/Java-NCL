package tests;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class AssessmentStatement extends StyleElement {
	
	private Attr comparator;
	
	private LinkedList<StyleElement> children = new LinkedList<StyleElement>();

	public AssessmentStatement(Document DOM, String comparator) {
		super(DOM, StyleElementTag.ASSESSMENT_STATEMENT);
		this.comparator.setValue(comparator);
		this.element.setAttributeNode(this.comparator);
	}

	@Override
	protected void createAllAttributes() {
		this.comparator = DOM.createAttribute("comparator");
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
	
	public void setComparator(String comparator){
		this.comparator.setValue(comparator);
	}
	
	public String getComparator(){
		return this.comparator.getValue();
	}

}
