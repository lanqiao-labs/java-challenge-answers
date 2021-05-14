
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Teacher Tao
 */
public class DomParseXml {
    /**
     * 采用 DOM 解析方式进行文档解析
     * @param filename 文档路径和名称
     */
    public void parseFile(String filename) {
        
        // 程序代码
        try {   	
        	
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document document = db.parse(filename);
			
			Element root = document.getDocumentElement();
			
			NodeList nl = root.getElementsByTagName("book");
			
			for(int i = 0; i < nl.getLength(); i++) {
				Element book = (Element) nl.item(i);
				
				System.out.println("编号:" + book.getAttribute("id"));
				
				NodeList nlbook = book.getElementsByTagName("bookname");
				System.out.println("书名:" + nlbook.item(0).getFirstChild().getNodeValue());
				
				nlbook = book.getElementsByTagName("bookauthor");
				System.out.println("作者:" + nlbook.item(0).getFirstChild().getNodeValue());
				
				nlbook = book.getElementsByTagName("bookprice");
				System.out.println("价格:" + nlbook.item(0).getFirstChild().getNodeValue());
				
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        
    }
    
    public static void main(String[] args) {
        new DomParseXml().parseFile("/home/project/books1.xml");

    }
}