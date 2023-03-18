package baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Bracket9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        for(int i=0; i<num; i++){
            Stack<Character> stack = new Stack<>();
            char[] seq = sc.next().toCharArray();
            for(int j=0; j<seq.length; j++){
                if(stack.isEmpty()){
                    stack.push(seq[j]);
                } else {
                    if(stack.peek() == '(' && seq[j] == ')'){
                        stack.pop();
                    } else {
                        stack.push(seq[j]);
                    }
                }
            }
            if(!stack.isEmpty()){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
