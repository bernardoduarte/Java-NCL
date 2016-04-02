package tests;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateStyleFileTester {
	
	/*
	 * Creates a static listing example.
	 */
	
	public static void Listing1(Document doc){
		Layout layout = new Layout(doc, "firstLayout");

		doc.appendChild(layout.getElement());
		
		Head head = new Head(doc);
		Body body = new Body(doc, "firstBody");
		
		layout.setHead(head);
		layout.setBody(body);
		
		Container container = new Container(doc, "foo");
		
		body.appendChild(container);

		Item itemA = new Item(doc, "A");
		itemA.setTop(0);
		itemA.setLeft(100);
		itemA.setWidth(260);
		itemA.setHeight(195);

		Item itemB = new Item(doc, "B");
		itemB.setWidth(260);
		itemB.setHeight(195);

		Item itemC = new Item(doc, "C");
		itemC.setWidth(260);
		itemC.setHeight(195);

		SpatialConstraint dist1 = new SpatialConstraint(doc, "dist1");
		dist1.setType("distribute");
		dist1.setDirection("horizontal");
		dist1.setOffset(10);
		Bind bind1 = new Bind(doc);
		bind1.setComponent(itemA.getElement());
		bind1.setInterface("right");
		dist1.appendBinding(bind1);
		Bind bind2 = new Bind(doc);
		bind2.setComponent(itemB.getElement());
		bind2.setInterface("right");
		dist1.appendBinding(bind2);
		Bind bind3 = new Bind(doc);
		bind3.setComponent(itemC.getElement());
		bind3.setInterface("right");
		dist1.appendBinding(bind3);

		SpatialConstraint align1 = new SpatialConstraint(doc, "align1");
		align1.setType("align");
		Bind bind4 = new Bind(doc);
		bind4.setComponent(itemA.getElement());
		bind4.setInterface("bottom");
		align1.appendBinding(bind4);
		Bind bind5 = new Bind(doc);
		bind5.setComponent(itemB.getElement());
		bind5.setInterface("top");
		align1.appendBinding(bind5);

		SpatialConstraint align2 = new SpatialConstraint(doc, "align2");
		align2.setType("align");
		Bind bind6 = new Bind(doc);
		bind6.setComponent(itemB.getElement());
		bind6.setInterface("top");
		align2.appendBinding(bind6);
		Bind bind7 = new Bind(doc);
		bind7.setComponent(itemC.getElement());
		bind7.setInterface("bottom");
		align2.appendBinding(bind7);

		container.appendChild(itemA);
		container.appendChild(itemB);
		container.appendChild(itemC);

		container.appendChild(dist1);
		container.appendChild(align1);
		container.appendChild(align2);
	}

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = 
			dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			Listing1(doc);

			// write the content into xml file
			TransformerFactory transformerFactory =
			TransformerFactory.newInstance();
			Transformer transformer =
			transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(".\\styleExample2.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult =
			new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

