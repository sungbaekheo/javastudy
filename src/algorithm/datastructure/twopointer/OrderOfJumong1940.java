package algorithm.datastructure.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class OrderOfJumong1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int con = sc.nextInt();
        int[] materials = new int[n];
        int answer = 0;

        for(int i=0; i<n; i++){
            materials[i] = sc.nextInt();
        }

        Arrays.sort(materials);

        int front = 0;
        int rear = n-1;

        while(front < rear){
            int curr = materials[front] + materials[rear];
            
            if(curr == con){
                answer++;
                front++;
                rear--;
            } else if(curr < con){
                front++;
            } else {
                rear--;
            }
        }

        System.out.println(answer);
        
    }
}
