package baekjoon.gold;

import java.util.Scanner;

public class StackDice2116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nDice = sc.nextInt();
        int[][] dice = new int[nDice][6];

        for(int i=0; i<nDice; i++){
            for(int j=0; j<6; j++){
                dice[i][j] = sc.nextInt();
            }
        }

        int totalMax = 0;
        for(int i=0; i<6; i++){
            int top = dice[0][(i == 0)? 5:(i == 1)? 3:(i == 2)? 4:(i == 3)? 1:(i == 4)? 2:0];
            int max = 0;
            int innerIdx = 0;
            int indx1 = 0;
            for(int j=0; j<nDice; j++){
                int diceMax = 0;
                for(int k=0; k<6; k++){
                    if(dice[j][k] == top){
                        innerIdx = k;
                    }
                }
                indx1 = (innerIdx == 0)? 5:(innerIdx == 1)? 3:(innerIdx == 2)? 4:(innerIdx == 3)? 1:(innerIdx == 4)? 2:0; 
                top = dice[j][indx1];
                for(int l=0; l<6; l++){
                    if(l == innerIdx || l == indx1){
                        continue;
                    }
                    if(diceMax < dice[j][l]){
                        diceMax = dice[j][l];
                    }
                }
                max+=diceMax;
            }
            if(max > totalMax){
                totalMax = max;
            }
        }
        System.out.println(totalMax);
    }
}
