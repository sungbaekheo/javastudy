package baekjoon.bronze;

import java.util.Scanner;

public class YoungsikAndHisFriends1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seats = sc.nextInt();
        int endCondition = sc.nextInt();
        int passTo = sc.nextInt();
        
        int[] players = new int[seats];
        int count = 0;
        int currentPlayer = 0;
        while(true){
            players[currentPlayer]++;
            int ballCount = players[currentPlayer];
            if((ballCount != endCondition) &&(ballCount%2 == 0)){
                count++;
                currentPlayer = (currentPlayer-passTo+seats)%seats;
            } else if((ballCount != endCondition) && (ballCount%2 != 0)){
                count++;
                currentPlayer = (currentPlayer+passTo+seats)%seats;
            } else{
                break;
            }
        }
        System.out.println(count);
    }
}
