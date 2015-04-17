package xpath;

import javax.xml.xpath.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;

import java.net.URL;
import java.util.Scanner;
class XPATH {

    static void print ( Node e ) {
	if (e instanceof Text)
	    System.out.print(((Text) e).getData());
	else {
	    NodeList c = e.getChildNodes();
	    System.out.print("<"+e.getNodeName());
	    NamedNodeMap attributes = e.getAttributes();
	    for (int i = 0; i < attributes.getLength(); i++)
		System.out.print(" "+attributes.item(i).getNodeName()
				 +"=\""+attributes.item(i).getNodeValue()+"\"");
	    System.out.print(">");
	    for (int k = 0; k < c.getLength(); k++)
		print(c.item(k));
	    System.out.print("</"+e.getNodeName()+">");
	}
    }
    static void eval ( String query, String url) throws Exception {
	XPathFactory xpathFactory = XPathFactory.newInstance();
	XPath xpath = xpathFactory.newXPath();
	//InputSource inputSource = new InputSource(document);
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document doc = db.parse((new URL(url)).openStream());
	NodeList result = (NodeList) xpath.evaluate(query,doc,XPathConstants.NODESET);
	System.out.println("XPath query: "+query);
	for (int i = 0; i < result.getLength(); i++)
	    print(result.item(i));
	System.out.println();
    }
    public static void main ( String[] args ) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a Keyword: ");
    String keyword_value = scanner.next();	
	eval("//categories/category/items/product[rating/rating>='3.50']/fullDescription","http://sandbox.api.ebaycommercenetwork.com/publisher/3.0/rest/GeneralSearch?apiKey=authorized-key&trackingId=7000610&keyword="+keyword_value);
	eval("//categories/category/items/product/fullDescription","http://sandbox.api.ebaycommercenetwork.com/publisher/3.0/rest/GeneralSearch?apiKey=78b0db8a-0ee1-4939-a2f9-d3cd95ec0fcc&visitorUserAgent&visitorIPAddress&trackingId=7000610&categoryId=72");
	eval("//categories/category/items/product[minPrice>=1000 and maxPrice<=2000]/name","http://sandbox.api.ebaycommercenetwork.com/publisher/3.0/rest/GeneralSearch?apiKey=authorized-key&trackingId=7000610&keyword="+keyword_value);
    }
}