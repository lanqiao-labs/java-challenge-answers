import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * Dom4j 解析 XML 数据信息
 * @author 小桃子
 */
public class Dom4jParseXml {
    /**
     * 采用Dom4j框架进行文档解析
     * @param filename 文档路径和名称
     */
    public void parseFile(String filename) {
        // 创建 SAX 解析对象
        SAXReader reader = new SAXReader();

        try {
            // 获取文档对象
            Document document = reader.read(filename);

            // 获取根元素
            Element root = document.getRootElement();
            
            // 获取子元素集合信息
            List<Element> books = root.elements("book");
            for (Element book : books) {
                //获取属性信息
                Attribute attid = book.attribute("id");
                if(attid != null){
                    System.out.println("编号：" + attid.getValue());
                }
                Element bookname = book.element("bookname");
                System.out.println("书名：" + bookname.getText());
                System.out.println("作者：" + book.elementText("bookauthor"));
                System.out.println("价格：" + book.elementText("bookprice"));
            }    
        } catch (DocumentException e) {
            e.printStackTrace();
        }    
    }

    public static void main(String[] args) {
        new Dom4jParseXml().parseFile("/home/project/books2.xml");
    }
}