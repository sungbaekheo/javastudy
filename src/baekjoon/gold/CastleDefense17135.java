package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CastleDefense17135 {
  static int row;
  static int col;
  static int d;
  static int[][] map;
  static int killed = Integer.MIN_VALUE;
  static int[] arrangement;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    map = new int[row+1][col];
    arrangement = new int[col];
    for(int r=0; r<row; r++){
      st = new StringTokenizer(br.readLine());
      for(int c=0; c<col; c++){
        map[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    arrange(0, 0);
    System.out.println(killed);
  }

  public static void defense(int[] arrangement){
    int tempKilled = 0;
    int[] line = new int[col];
    int[][] tempMap = new int[row+1][col];
    copyMap(tempMap);
    tempMap[row] = arrangement;

    while(!isCleared(tempMap)){
      int[][] targets = new int[3][2];
      int a = -1;
      for(int i=0; i<col; i++){
        if(tempMap[row][i] != 2){
          continue;
        }
        a++;
        targets[a] = null;
        int tDist = Integer.MAX_VALUE;
        for(int r=row-1; r>0; r--){
          for(int c=0; c<col; c++){
            int dist = Math.abs(row-r)+Math.abs(i-c);
            if(dist>d){
              continue;
            }
            if(tempMap[r][c] == 1){
              if(dist<=tDist){
                if(tDist > dist){
                  tDist = dist;
                  targets[a] = new int[] {r, c};
                } else {
                  if(targets[a][1] > c){
                    targets[a] = new int[] {r, c};
                  }
                }
              }
            }
          }
        }
      }
      for(int[] target : targets){
        if(target == null){
          continue;
        }
        if(tempMap[target[0]][target[1]] == 1){
          tempMap[target[0]][target[1]] = 0;
          tempKilled++;
        }
      }

      for(int i=row-1; i>=0; i--){
        if(i == 0){
          changeArray(tempMap[i], line);
        } else {
          changeArray(tempMap[i], tempMap[i-1]);
        }
      }
    }
    killed = Math.max(killed, tempKilled);
  }

  public static void arrange(int idx, int cnt){
    if(idx == col){
      if(cnt == 3){
        defense(arrangement);
      }
      return;
    }
    arrangement[idx] = 0;
    arrange(idx+1, cnt);
    if(cnt<3){
      arrangement[idx] = 2;
      arrange(idx+1, cnt+1);
    }
  }

  public static void copyMap(int[][] copied){
    for(int r=0; r<=row; r++){
      for(int c=0; c<col; c++){
        copied[r][c] = map[r][c];
      }
    }
  }

  public static boolean isCleared(int[][] tempMap){
    for(int r=0; r<row; r++){
      for(int c=0; c<col; c++){
        if(tempMap[r][c] == 1){
          return false;
        }
      }
    }
    return true;
  }

  public static void changeArray(int[] arr1, int[] arr2){
    for(int i=0; i<col; i++){
      arr1[i] = arr2[i];
    }
  }
}
