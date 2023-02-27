package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> li = new LinkedList<>();

        int nPeople = sc.nextInt();
        int interval = sc.nextInt();

        for(int i=1; i<=nPeople; i++){
            li.add(i);
        }

        sb.append("<");
        int count = 1;
        int idx = 0;
        while(!li.isEmpty()){
            idx = idx%li.size();
            if(count == interval){
                sb.append(li.remove(idx));
                count = 1;
                if(li.size() == 0){
                    sb.append(">");
                } else {
                    sb.append(", ");
                }
            }
            count++;
            idx++;
        }
        System.out.println(sb.toString());
    }
}