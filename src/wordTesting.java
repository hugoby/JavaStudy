import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Package_name PACKAGE_NAME
 * Project_name JavaStudy
 * Created by lenovo on 2015/12/15 11:21
 */

public class wordTesting{
    public static void main(String[]args){
        try{
            InputStream is=new FileInputStream(new File("456.doc"));
            WordExtractor ex=new WordExtractor(is);
            String text2003=ex.getText();
            System.out.println(text2003);

            OPCPackage opcPackage= POIXMLDocument.openPackage("456.doc");
            POIXMLTextExtractor extractor=new XWPFWordExtractor(opcPackage);

            String text2007=extractor.getText();
            System.out.println(text2007);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

