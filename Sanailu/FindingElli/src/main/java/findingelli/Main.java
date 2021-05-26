
package findingelli;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        FinnishWordList sanat = new FinnishWordList(".././files/kotus-sanalista.xml");
        ArrayList<String> sanatText = sanat.getList();
        
        printElliWords(sanatText);
    }
    
    public static void printElliWords(ArrayList<String> words) {
        int total = 0;
        for (String word : words) {
            if (word.toLowerCase().contains("elli")) {
                System.out.println(word);
                total++;
            }
        }
        System.out.println("Yhteensä " + total + " kpl");
    }    
}
