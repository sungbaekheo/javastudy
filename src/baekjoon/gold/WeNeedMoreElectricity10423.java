package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WeNeedMoreElectricity10423 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 가장 적은 코스트 순으로 뽑기 위해 우선순위 큐를 사용했음
		// 우선순위 큐 안의 int형 배열은 {도착지점, 가중치}임
		// Comparator를 통해 가중치를 기준으로 우선순위큐를 구현
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		
		// 순서대로 도시의 개수(노드), 케이블의 수(간선), 발전소의 개수
		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		int powerPlant = Integer.parseInt(st.nextToken());
		
		// 가중치를 포함한 인접리스트 구현
		// 리스트 안에는 {도착지점, 가중치} 배열이 들어 있음
		List<int[]>[] cities = new ArrayList[nodes+1];
		// 방문처리 배열
		boolean[] visited = new boolean[nodes+1];
		
		// 인접리스트를 초기화 시켜줌
		for(int i=0; i<=nodes; i++) {
			cities[i] = new ArrayList<>(); 
		}
		
		st = new StringTokenizer(br.readLine());
		// 발전소가 있는 도시들이 주어지면 미리 방문처리를 해놓음
		for(int i=0; i<powerPlant; i++) {
			int plant = Integer.parseInt(st.nextToken());
			visited[plant] = true;
		}
		
		for(int i=0; i<edges; i++) {
			st = new StringTokenizer(br.readLine());
			// 전기가 나가는 도시, 받는 도시, 가중치 순
			int front = Integer.parseInt(st.nextToken());
			int rear = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프이므로 양쪽다 받아줌
			cities[front].add(new int[] {rear, weight});
			cities[rear].add(new int[] {front, weight});
		}
		
		// 맨 처음 발전소가 있는 도시들을 방문처리해줬기 때문에 그 도시들부터 시작하면 됨
		for(int i=1; i<visited.length; i++) {
			// 방문처리 배열을 쭉 돌면서 방문한 도시들이 있다면
			if(visited[i]) {
				// 해당 도시와 연결된 도시들을 인접리스트에서 찾아서 우선순위 큐에 넣어줌
				for(int j=0; j<cities[i].size(); j++) {
					pq.offer(cities[i].get(j));
				}
			}
		}
		
		// 뽑힌 케이블 수
		int selected = 0;
		// 케이블을 설치하는데 드는 비용
		int cost = 0;
		
		// 큐가 빌 때까지 반복
		while(!pq.isEmpty()) {
			// 가장 우선순위에 있는 노드를 뽑아서
			int[] now = pq.poll();
			// 만약 해당 도착하는 지점이 방문한 적이 없다면
			if(!visited[now[0]]) {
				// 방문처리 하고
				visited[now[0]] = true;
				// 코스트 더해주고
				cost+=now[1];
				// 고른 케이블 수를 1 더해준다.
				selected++;
				
				// 그리고나서 현재 도착한 노드에서 갈 수 있는 도시들을 찾아서 우선순위 큐에 넣는다.
				for(int i=0; i<cities[now[0]].size(); i++) {
					pq.offer(cities[now[0]].get(i));
				}
			}
			
			// 모든 도시에 전기를 연결할 수 있도록 케이블을 설치하는 최소 수는 도시의 수 - 발전소의 수이므로
			// 이만큼 케이블 설치가 완료되었다면 반복문 종료
			if(selected == nodes-powerPlant) {
				break;
			}
		}
		// 최후에 저장된 코스트를 출력한다.
		System.out.println(cost);
	}
}