/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristikkovelho;

import java.util.ArrayList;
import java.util.Scanner;

public class WordSearch {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        FinnishWordList words = new FinnishWordList("./files/kotus-sanalista.xml");
        ArrayList<String> wordList = words.getList();

        System.out.println("KIRJOITA EHTO - piste=tyhjä");
        String condition = scanner.nextLine();
        
        findWords(condition, wordList);
    }
    
    // ei takuulla tehokkain haku, mutta tekee työnsä
    public static void findWords(String condition, ArrayList<String> words) {
        String[] conds = condition.split("");
        int total = 0;
        for (String word : words) {
            String[] letters = word.split("");
            if (conds.length == letters.length) {
                boolean ok = true;
                for (int i = 0; i < conds.length; i++) {
                    if (!conds[i].equals(".") && !conds[i].equals(letters[i])) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println(word);
                    total++;
                }
            }
        }
        System.out.println("Yhteensä " + total + " sanaa.");
    }
}
