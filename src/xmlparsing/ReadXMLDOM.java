package xmlparsing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




public class ReadXMLDOM {
public static void main(String[] args) {
	String filepath="employee.xml";
	File xmlfile=new File(filepath);
	DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
	DocumentBuilder dbuilder;
	try {
		dbuilder=dbfactory.newDocumentBuilder();
		Document doc=dbuilder.parse(xmlfile);
		doc.getDocumentElement().normalize();
		System.out.println("Root element is : "+doc.getDocumentElement().getNodeName());
		NodeList nodelist=doc.getElementsByTagName("employee");
		List<Employee>emplist=new ArrayList<Employee>();
		for(int i=0;i<nodelist.getLength();i++){
			emplist.add(getEmployee(nodelist.item(i)));
			
		}
		for(Employee emp:emplist){
			System.out.println(emp.toString());
		}
		
	} catch (ParserConfigurationException | SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	
}

private static Employee getEmployee(Node node) {
	Employee emp=new Employee();
	if(node.getNodeType()==Node.ELEMENT_NODE){
		Element element=(Element)node;
		emp.setfirstname(getTagValue("firstname",element));
		emp.setlastname(getTagValue("lastname",element));
		
		emp.setlocation(getTagValue("location",element));
	}
	return emp;
}

private static String getTagValue(String tag ,Element element) {
	NodeList nodelist=element.getElementsByTagName(tag).item(0).getChildNodes();
	Node node=(Node)nodelist.item(0);	
	// TODO Auto-generated method stub
	return node.getNodeValue();
}
}
