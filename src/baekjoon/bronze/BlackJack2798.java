package baekjoon.bronze;

import java.util.Scanner;

public class BlackJack2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nCard = sc.nextInt();
        int limit = sc.nextInt();
        int[] cardList = new int[nCard];

        for(int i=0; i<nCard; i++){
            cardList[i] = sc.nextInt();
        }

        int maxPoint = 0;
        for(int i=0; i<nCard; i++){
            for(int j=i+1; j<nCard; j++){
                for(int k=j+1; k<nCard; k++){
                    int currentScore = cardList[i] + cardList[j] + cardList[k];
                    if(currentScore > maxPoint && currentScore <= limit){
                        maxPoint = currentScore;
                    }
                }
            }
        }
        System.out.println(maxPoint);
    }
}
