package baekjoon.array;

import java.util.Scanner;

public class OXQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            char[] oxList = sc.next().toCharArray();
            int sum = 0;
            int count = 0;
            for(int j=0; j<oxList.length; j++){
                if(String.valueOf(oxList[j]).equals("O")){
                    count++;
                }else{
                    count = 0;
                }
                sum+=count;
            }
            System.out.println(sum);
        }
    }
}
