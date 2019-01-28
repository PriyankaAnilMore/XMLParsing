package xmlparsing;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXmlFile{ //extends org.xml.sax.helpers.DefaultHandler {
	// static SAXParser saxParser=null;
	public static void main(String[] args) {
		try {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser saxParser = factory.newSAXParser();
		DefaultHandler handler=new DefaultHandler()
		{
			//	boolean bid=false;
				boolean blastname=false;
					boolean blocation=false;
						boolean bfirstname=false;

						public void startElement(String uri,String localname,String qname,Attributes attributes)throws SAXException{
							//	if(qname.equalsIgnoreCase("id")){
								//		bid=true;
								//			}
									if(qname.equalsIgnoreCase("firstname")){
											bfirstname=true;
											}
										if(qname.equalsIgnoreCase("lastname")){
												blastname=true;
											}
											if(qname.equalsIgnoreCase("location")){
												blocation=true;
											}
						}
						public void endElement(String uri,String localname,String qname,Attributes attributes)throws SAXException{}	
						public void characters(char ch[],int start,int length)throws SAXException{
							//	if(bid){
								//	System.out.println("id : "+new String(ch,start,length));
									//bid=false;
											//}
								if(bfirstname){
									System.out.println("firstname : "+new String(ch,start,length));
									bfirstname=false;
									}
									if(blastname){
										System.out.println("lastname : "+new String(ch,start,length));
										blastname=false; }
									if(blocation){
										System.out.println("location : "+new String(ch,start,length));
										blocation=false;}
}};
     try {
		saxParser.parse("employee.xml" , handler);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	



}}