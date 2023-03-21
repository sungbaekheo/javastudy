package baekjoon.silver;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class PrinterQueue1966 {
   public static void main(String args[]){ 
    Scanner sc = new Scanner(System.in);
    Queue<Integer> printer = new LinkedList<>();
    
    int testCase = sc.nextInt();
    for(int t=0; t<testCase; t++){
      printer.clear();
      
      int n = sc.nextInt();
      int target = sc.nextInt();
      int[] printList = new int[n];
      
      for(int i=0; i<n; i++){
        printList[i] = sc.nextInt();
        printer.offer(i);
      }
      
      int order = 1;
      while(!printer.isEmpty()){
        boolean isSuperior = true;
        int idx = printer.poll();
        for(int i=0; i<n; i++){
          if(printList[i] > printList[idx]){
            printer.offer(idx);
            isSuperior = false;
            break;
          }
        }
        if(isSuperior){
          if(target == idx){
            System.out.println(order);
            break;
          } else {
            order++;
            printList[idx] = -1;
          }
        }
      }
    }
   }
 }