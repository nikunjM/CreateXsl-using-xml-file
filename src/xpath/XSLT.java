package xpath;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.net.URL;


class XSLT {
    public static void main ( String argv[] ) throws Exception {
	File stylesheet = new File("xslt-example.xsl");
	//File xmlfile  = new File("cs.xml");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
    Document document= db.parse((new URL("http://sandbox.api.ebaycommercenetwork.com/publisher/3.0/rest/GeneralSearch?apiKey=78b0db8a-0ee1-4939-a2f9-d3cd95ec0fcc&trackingId=7000610&category=72&keyword=sony")).openStream());
	StreamSource stylesource = new StreamSource(stylesheet);
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer(stylesource);
	DOMSource source = new DOMSource(document);
	StreamResult result = new StreamResult(System.out);
	transformer.transform(source,result);
    }
}