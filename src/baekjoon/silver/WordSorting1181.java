package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordSorting1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        Set<String> wordset = new HashSet<>();
        for(int i=0; i<len; i++){
            wordset.add(sc.next());
        }
        List<String> words = new ArrayList<>(wordset);
        Collections.sort(words);
        Collections.sort(words, new Comparator<String>(){
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
            
        });

        for(int i=0; i<words.size(); i++){
            System.out.println(words.get(i));
        }
    }
}
