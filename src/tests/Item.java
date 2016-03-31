package tests;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class Item extends StyleElement{

	private Attr id;
	private Attr top;
	private Attr left;
	private Attr right;
	private Attr bottom;
	private Attr width;
	private Attr height;
	private Attr focusIndex;
	
	public Item(Document DOM, String id){
		super(DOM, "item");
		this.id.setValue(id);
		this.element.setAttributeNode(this.id);
	}
	
	protected void createAllAttributes(){
		this.id = DOM.createAttribute("id");
		this.top = DOM.createAttribute("top");
		this.left = DOM.createAttribute("left");
		this.right = DOM.createAttribute("right");
		this.bottom = DOM.createAttribute("bottom");
		this.width = DOM.createAttribute("width");
		this.height = DOM.createAttribute("height");
		this.focusIndex = DOM.createAttribute("focusIndex");
	}
	
	public void removeAttribute(String attrib){
		this.element.removeAttribute(attrib);
	}

	public void setId(String id){
		this.id.setValue(id);
	}
	
	public String getId(){
		return this.id.getValue();
	}
	
	public void setTop(int value){
		this.top.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.top);
	}
	
	public int getTop(){
		return Integer.parseInt(this.top.getValue());
	}
	
	public void setLeft(int value){
		this.left.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.left);
	}
	
	public int getLeft(){
		return Integer.parseInt(this.left.getValue());
	}
	
	public void setRight(int value){
		this.right.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.right);
	}
	
	public int getRight(){
		return Integer.parseInt(this.right.getValue());
	}
	
	public void setBottom(int value){
		this.bottom.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.bottom);
	}
	
	public int getBottom(){
		return Integer.parseInt(this.bottom.getValue());
	}
	
	public void setWidth(int value){
		this.width.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.width);
	}
	
	public int getWidth(){
		return Integer.parseInt(this.width.getValue());
	}
	
	public void setHeight(int value){
		this.height.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.height);
	}
	
	public int getHeight(){
		return Integer.parseInt(this.height.getValue());
	}
	
	public void setFocusIndex(int value){
		this.focusIndex.setValue(String.valueOf(value));
		this.element.setAttributeNode(this.focusIndex);
	}
	
	public int getFocusIndex(){
		return Integer.parseInt(this.focusIndex.getValue());
	}
	
}
