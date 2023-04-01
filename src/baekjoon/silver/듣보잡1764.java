package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 듣보잡1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<n; i++){
            map.put(sc.next(), 1);
        }
        int count = 0;
        for(int i=0; i<m; i++){
            String str = sc.next();
            if(map.getOrDefault(str, 0) == 1){
                names.add(str);
                count++;
            }
        }
        Collections.sort(names);
        System.out.println(count);
        for(int i=0; i<count; i++){
            System.out.println(names.get(i));
        }
    }
}
