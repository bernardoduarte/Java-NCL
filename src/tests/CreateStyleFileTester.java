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
import java.util.Properties;

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
	
	public static void Listing2(Document doc){
		Layout layout = new Layout(doc, "LayoutAppExAmple");
		doc.appendChild(layout.getElement());
		
		Head head = new Head(doc);
		layout.setHead(head);
		
		ConstraintConnectorBase ccb = new ConstraintConnectorBase(doc, "const", "constraint.xml");
		head.addConstraintConnectorBase(ccb);
		
		Body body = new Body(doc, "body");
		layout.setBody(body);
		
		Container cont1 = new Container(doc, "menu");
		cont1.setType(ContainerLayout.GRID);
		cont1.setFocusIndex(1);
		Format f1 = new Format(doc);
		f1.setTop(0);
		f1.setLeft(0);
		f1.setWidth(100);
		f1.setHeight(400);
		f1.setColumns(1);
		f1.setRows(4);
		f1.setVSpace(0);
		f1.setHSpace(0);
		cont1.setFormat(f1);
		body.appendChild(cont1);
		
		Container cont2 = new Container(doc, "grid");
		cont2.setType(ContainerLayout.GRID);
		cont2.setFocusIndex(1);
		Format f2 = new Format(doc);
		f2.setWidth(600);
		f2.setHeight(500);
		f2.setColumns(4);
		f2.setRows(3);
		f2.setVSpace(0);
		f2.setHSpace(0);
		cont2.setFormat(f2);
		body.appendChild(cont2);
		
		Container cont3 = new Container(doc, "info");
		cont3.setType(ContainerLayout.FLOW);
		cont3.setFocusIndex(1);
		Format f3 = new Format(doc);
		f3.setWidth(300);
		f3.setHeight(600);
		f3.setVSpace(0);
		f3.setHSpace(0);
		cont3.setFormat(f3);
		Item i1 = new Item(doc, "item1");
		i1.setWidth(300);
		i1.setHeight(600);
		cont3.appendChild(i1);
		body.appendChild(cont3);
		
		Container cont4 = new Container(doc, "videos");
		cont4.setType(ContainerLayout.FLOW);
		cont4.setFocusIndex(1);
		Format f4 = new Format(doc);
		f4.setWidth(1000);
		f4.setHeight(400);
		f4.setVSpace(10);
		f4.setHSpace(0);
		cont4.setFormat(f4);
		Item i2 = new Item(doc, "item1");
		i2.setWidth(200);
		i2.setHeight(400);
		cont4.appendChild(i2);
		body.appendChild(cont4);
		
		SpatialConstraint sc1 = new SpatialConstraint(doc, "dist1");
		sc1.setType("distribute");
		sc1.setDirection("horizontal");
		Bind b1 = new Bind(doc);
		b1.setComponent(cont1.getElement());
		b1.setInterface("right");
		sc1.appendBinding(b1);
		Bind b2 = new Bind(doc);
		b2.setComponent(cont2.getElement());
		b2.setInterface("right");
		sc1.appendBinding(b2);
		Bind b3 = new Bind(doc);
		b3.setComponent(cont3.getElement());
		b3.setInterface("right");
		sc1.appendBinding(b3);
		body.appendChild(sc1);
		
		SpatialConstraint sc2 = new SpatialConstraint(doc, "align1");
		sc2.setType("align");
		Bind b4 = new Bind(doc);
		b4.setComponent(cont1.getElement());
		b4.setInterface("top");
		sc2.appendBinding(b4);
		Bind b5 = new Bind(doc);
		b5.setComponent(cont2.getElement());
		b5.setInterface("top");
		sc2.appendBinding(b5);
		Bind b6 = new Bind(doc);
		b6.setComponent(cont3.getElement());
		b6.setInterface("top");
		sc2.appendBinding(b6);
		body.appendChild(sc2);
		
		SpatialConstraint sc3 = new SpatialConstraint(doc, "align2");
		sc3.setType("align");
		Bind b7 = new Bind(doc);
		b7.setComponent(cont1.getElement());
		b7.setInterface("left");
		sc3.appendBinding(b7);
		Bind b8 = new Bind(doc);
		b8.setComponent(cont4.getElement());
		b8.setInterface("left");
		sc3.appendBinding(b8);
		body.appendChild(sc3);
		
		SpatialConstraint sc4 = new SpatialConstraint(doc, "align3");
		sc4.setType("align");
		sc4.setOffset(50);
		Bind b9 = new Bind(doc);
		b9.setComponent(cont3.getElement());
		b9.setInterface("bottom");
		sc4.appendBinding(b9);
		Bind b10 = new Bind(doc);
		b10.setComponent(cont4.getElement());
		b10.setInterface("top");
		sc4.appendBinding(b10);
		body.appendChild(sc4);
		
	}

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory =
			DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = 
			dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			Listing2(doc);

			// write the content into xml file
			TransformerFactory transformerFactory =
			TransformerFactory.newInstance();
			Transformer transformer =
			transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");	
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(".//styleExample9.xml"));
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

