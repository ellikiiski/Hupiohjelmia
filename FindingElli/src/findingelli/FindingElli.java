
package findingelli;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class FindingElli {

    public static void main(String[] args) {
        
        FinnishWordList sanat = new FinnishWordList("./files/kotus-sanalista.xml");
        ArrayList<String> sanatText = sanat.getLista();
        
        printElliWords(sanatText);
    }
    
    public static void printElliWords(ArrayList<String> words) {
        int total = 0;
        for (String word : words) {
            if (word.toLowerCase().contains("ille")) {
                System.out.println(word);
                total++;
            }
        }
        System.out.println("Yhteensä " + total + " kpl");
    }
    
}
