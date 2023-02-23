package baekjoon.silver;

import java.util.Scanner;

public class Stack10828 {
    static int[] stack = new int[10000];
    static int top = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String o = sc.next();
            switch(o){
                case "push": push(sc.nextInt()); break;
                case "pop": sb.append(pop()+"\n"); break;
                case "size": sb.append(size()+"\n"); break;
                case "empty": sb.append(empty()+"\n"); break;
                case "top": sb.append(top()+"\n"); break;
            }
        }
        System.out.print(sb.toString());
    }

    public static void push(int num){
        stack[++top] = num;
    }

    public static int pop(){
        if(empty() ==1){
            return -1;
        }
        return stack[top--];
    }

    public static int size(){
        return top+1;
    }

    public static int empty(){
        if(top == -1){
            return 1;
        } else{
            return 0;
        }
    }

    public static int top(){
        if(empty() == 1){
            return -1;
        } else {
            return stack[top];
        }
    }
}