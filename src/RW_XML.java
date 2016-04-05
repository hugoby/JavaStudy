import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Package_name PACKAGE_NAME
 * Project_name JavaStudy
 * Created by lenovo on 2016/4/4 16:37
 */
public class RW_XML {
    public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder=dbFactory.newDocumentBuilder();
        Document doc=null;
        doc=dbBuilder.parse("D:/document/Projects/Fosstrak_Project/fosstrak-epcis_wwh/keyStore.xml");
        NodeList list=doc.getElementsByTagName("keyStore");

        for(int i=0;i<list.getLength();i++){
            Element element=(Element)list.item(i);
            String publicKey=element.getElementsByTagName("publicKey").item(0).getFirstChild().getNodeValue();
            String privateKey=element.getElementsByTagName("privateKey").item(0).getFirstChild().getNodeValue();
            System.out.println("PublicKey:" + publicKey);
            System.out.println("PrivateKey:"+privateKey);
        }
    }
}
