package tests;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class Format extends StyleElement{
	
	private Attr top;
	private Attr left;
	private Attr right;
	private Attr bottom;
	private Attr width;
	private Attr height;
	private Attr align;
	private Attr columns;
	private Attr rows;
	private Attr vspace;
	private Attr hspace;

	public Format(Document DOM) {
		super(DOM, StyleElementTag.FORMAT);
	}

	@Override
	protected void createAllAttributes() {
		this.top = DOM.createAttribute("top");
		this.left = DOM.createAttribute("left");
		this.right = DOM.createAttribute("right");
		this.bottom = DOM.createAttribute("bottom");
		this.width = DOM.createAttribute("width");
		this.height = DOM.createAttribute("height");
		this.align = DOM.createAttribute("align");
		this.vspace = DOM.createAttribute("vspace");
		this.hspace = DOM.createAttribute("hspace");
	}
	
	public void setTop(int top){
		this.top.setValue(String.valueOf(top));
		this.element.setAttributeNode(this.top);
	}
	
	public int getTop(){
		return Integer.parseInt(this.top.getValue());
	}
	
	public void setLeft(int left){
		this.left.setValue(String.valueOf(left));
		this.element.setAttributeNode(this.left);
	}
	
	public int getLeft(){
		return Integer.parseInt(this.left.getValue());
	}
	
	public void setRight(int right){
		this.right.setValue(String.valueOf(right));
		this.element.setAttributeNode(this.right);
	}
	
	public int getRight(){
		return Integer.parseInt(this.right.getValue());
	}
	
	public void setBottom(int bottom){
		this.bottom.setValue(String.valueOf(bottom));
		this.element.setAttributeNode(this.bottom);
	}
	
	public int getBottom(){
		return Integer.parseInt(this.bottom.getValue());
	}
	
	public void setWidth(int width){
		this.width.setValue(String.valueOf(width));
		this.element.setAttributeNode(this.width);
	}
	
	public int getWidth(){
		return Integer.parseInt(this.width.getValue());
	}
	
	public void setHeight(int height){
		this.height.setValue(String.valueOf(height));
		this.element.setAttributeNode(this.height);
	}
	
	public int getHeight(){
		return Integer.parseInt(this.height.getValue());
	}
	
	public void setAlign(String align){
		this.align.setValue(align);
		this.element.setAttributeNode(this.align);
	}
	
	public String getAlign(){
		return this.align.getValue();
	}
	
	public void setColumns(int columns){
		this.columns.setValue(String.valueOf(columns));
		this.element.setAttributeNode(this.columns);
	}
	
	public int getColumns(){
		return Integer.parseInt(this.columns.getValue());
	}
	
	public void setRows(int rows){
		this.rows.setValue(String.valueOf(rows));
		this.element.setAttributeNode(this.rows);
	}
	
	public int getRows(){
		return Integer.parseInt(this.rows.getValue());
	}
	
	public void setVSpace(int space){
		this.vspace.setValue(String.valueOf(space));
		this.element.setAttributeNode(this.vspace);
	}
	
	public int getVSpace(){
		return Integer.parseInt(this.vspace.getValue());
	}
	
	public void setHSpace(int space){
		this.hspace.setValue(String.valueOf(space));
		this.element.setAttributeNode(this.hspace);
	}
	
	
	
}
