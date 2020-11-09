
package findingelli;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class FinnishWordList {
    
    private String xmlFilePath;
    private ArrayList<String> words;
    
    public FinnishWordList(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
        words = new ArrayList<>();
    }
    
    public ArrayList<String> getLista() {
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
