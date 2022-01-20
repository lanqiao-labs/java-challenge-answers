import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParseXml extends DefaultHandler {

    private String elementname;
	private String bookname;
	private String bookprice;
	private String bookauthor;

    /**
     * 采用 SAX 解析方式进行文档解析
     * 
     * @param filename 文档路径和名称
     */
    public void parseFile(String filename) {

        // 程序代码
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new File(filename), this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
               
    }
    
    // 重写五个核心的方法
    @Override
    public void startDocument() throws SAXException {
       System.out.println("books2文档开始解析");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("books2文档结束解析");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("book".equals(qName)) {
            int id = Integer.parseInt(attributes.getValue(0));
            System.out.println("编号:" + id);
        }
        this.elementname = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("bookname".equals(qName)) {
			System.out.println("书名:"+this.bookname);
		}
		if("bookauthor".equals(qName)) {
			System.out.println("作者:"+this.bookauthor);
		}
		if("bookprice".equals(qName)) {
			System.out.println("价格:"+this.bookprice);
		}
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch,start,length);
		if("bookname".equals(elementname) && !"".equals(s.trim())) {
			this.bookname = s;
		}
		if("bookauthor".equals(elementname) && !"".equals(s.trim())) {
			this.bookauthor = s;
		}
		if("bookprice".equals(elementname) && !"".equals(s.trim())) {
			this.bookprice = s;
		}
    }

  
    public static void main(String[] args) {
			new SaxParseXml().parseFile("/home/project/books2.xml");
		}
}