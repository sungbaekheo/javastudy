package baekjoon.silver;

import java.util.Scanner;

public class KoreanMelonFarm2477 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int melons = sc.nextInt();
    int area = 0;
    int h = 0;
    int w = 0;
    int subArea = 0;
    int[] lens = new int[6];
    int[] order = new int[6];

    for(int p=0; p<6; p++){
      int d = sc.nextInt();
      int len = sc.nextInt();
      if(d == 1 || d == 2){
        w = Math.max(w, len);
      } else{
        h = Math.max(h, len);
      }
      order[p] = d;
      lens[p] = len;
    }
    if(order[0] == order[2] && order[1] == order[3]){
      subArea = lens[2]*lens[1];
    } else if(order[1] == order[3] && order[2] == order[4]){
      subArea = lens[3]*lens[2];
    } else if(order[2] == order[4] && order[3] == order[5]){
      subArea = lens[4]*lens[3];
    } else if(order[3] == order[5] && order[4] == order[0]){
      subArea = lens[5]*lens[4];
    } else if(order[4] == order[0] && order[5] == order[1]){
      subArea = lens[0]*lens[5];
    } else if(order[5] == order[1] && order[0] == order[2]){
      subArea = lens[1]*lens[0];
    }

    area = h*w-subArea;
    System.out.println(melons*area);
  }
}
