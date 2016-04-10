package style;

import java.util.LinkedList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Container extends StyleElement{
	
	private Attr id;
	private Attr type;
	private Attr focusIndex;
	
	private Format format;
	
	private LinkedList<StyleElement> children = new LinkedList<StyleElement>(); 
	
	public Container(Document DOM, String id){
		super(DOM, StyleElementTag.CONTAINER);
		this.id.setValue(id);
		this.element.setAttributeNode(this.id);
		this.element.setIdAttributeNode(this.id, true);
	}
	
	@Override
	protected void createAllAttributes(){
		this.id = DOM.createAttribute("id");
		this.type = DOM.createAttribute("type");
		this.focusIndex = DOM.createAttribute("focusIndex");
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
			/*if(newChild.hasChildNodes()){
				NodeList nodeList = newChild.getChildNodes();
				for(int index = 0; index < nodeList.getLength(); index++){
					Node node = nodeList.item(index);
					if(node.getNodeType() == Node.ELEMENT_NODE){
						this.appendChild((Element) node);
					}
				}
			}*/
		}
	}
	
	public void setId(String id){
		this.id.setValue(id);
	}
	
	public String getId(){
		return this.id.getValue();
	}
	
	public void setType(ContainerLayout type){
		this.type.setValue(ContainerLayout.getLayoutOf(type));
		this.element.setAttributeNode(this.type);
	}
	
	public String getType(){
		return this.type.getValue();
	}
	
	public void setFocusIndex(int value){
		this.focusIndex.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.focusIndex);
	}
	
	public int getFocusIndex(){
		return Integer.parseInt(this.focusIndex.getValue());
	}
	
	public void setFormat(Format format){
		this.format = format;
		this.appendChild(this.format);
	}
	
	public Format getFormat(){
		return this.format;
	}

}
