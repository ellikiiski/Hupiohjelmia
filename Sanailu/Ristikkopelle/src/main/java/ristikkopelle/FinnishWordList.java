
package ristikkopelle;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.ArrayList;

public class FinnishWordList {
    
    private final String xmlFilePath;
    private final ArrayList<String> words;
    
    public FinnishWordList(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
        words = new ArrayList<>();
    }
    
    public ArrayList<String> getList() {
        this.parseXMLtoWordlist();
        return this.words;
    }
    
    public void parseXMLtoWordlist() {        
        try {
            File file = new File(xmlFilePath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList sanat = doc.getElementsByTagName("s");
            for (int i = 0; i < sanat.getLength(); i++) {
                words.add(sanat.item(i).getTextContent());
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
