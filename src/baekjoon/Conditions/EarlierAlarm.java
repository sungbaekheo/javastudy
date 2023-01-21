package baekjoon.Conditions;

import java.util.Scanner;

public class EarlierAlarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hours = sc.nextInt();
        int minutes = sc.nextInt();

        if(minutes < 45){
            if(hours == 0){
                hours = 23;
            }else{
            hours--;
            }
            minutes = 60 + (minutes - 45);
        }else{
            minutes-=45;
        }

        System.out.println(hours + " " + minutes);
    }
}