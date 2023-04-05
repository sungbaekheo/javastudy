package algorithm.datastructure.twopointer;

import java.util.Scanner;

public class SumOfNumbers2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int front = 1;
        int rear = 2;
        int count = 1;
        int sum = front+rear;

        if(num>1){
            while(rear != num){
                if(sum == num){
                    count++;
                    rear++;
                    sum+=rear;
                } else if(sum>num){
                    sum-=front;
                    front++;
                } else{
                    rear++;
                    sum+=rear;
                }
            }
        }
        System.out.println(count);
    }
}
