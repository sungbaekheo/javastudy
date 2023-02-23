package baekjoon.silver;

import java.util.Scanner;

public class Queue10845{
  static int[] queue = new int[10000];
  static int front = -1, rear =-1;
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int testCase = sc.nextInt();
    
    for(int t=0; t<testCase; t++){
      String o = sc.next();
      switch(o){
        case "push": push(sc.nextInt()); break;
        case "pop": sb.append(pop()+"\n"); break;
        case "size": sb.append(size()+"\n"); break;
        case "empty": sb.append(empty()+"\n"); break;
        case "front": sb.append(front()+"\n"); break;
        case "back": sb.append(back()+"\n"); break;   
      }
    }
    System.out.println(sb.toString());
  }
  
  static void push(int num){
    queue[++rear] = num;
  }
  
  static int pop(){
    if(empty() == 1){
      return -1;
    } else {
      return queue[++front];
    }
  }
  
  static int size(){
    return rear - front;
  }
  
  static int empty(){
    if(front == rear){
      return 1;
    } else {
      return 0;
    }
  }
  
  static int front(){
    if(empty() == 1){
      return -1;
    } else {
      return queue[front+1];
    }
  }
  
  static int back(){
    if(empty() == 1){
      return -1;
    } else {
      return queue[rear];
    }
  }
}
