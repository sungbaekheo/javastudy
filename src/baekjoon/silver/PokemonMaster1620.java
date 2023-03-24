package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PokemonMaster1620 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    Map<Integer, String> byNum = new HashMap<>();
    Map<String, Integer> byName = new HashMap<>();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for(int i=1; i<=N; i++){
      String name = br.readLine();
      byNum.put(i, name);
      byName.put(name, i);
    }

    for(int i=0; i<M; i++){
      String input = br.readLine();
      if(input.charAt(0) <= '9'){
        sb.append(byNum.get(Integer.parseInt(input))+"\n");
      } else{
        sb.append(byName.get(input)+"\n");
      }
    }
    bw.write(sb.toString());
    bw.close();
  }
}
