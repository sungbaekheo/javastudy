package algorithm.tree.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindingParentOfTree11725 {
    static int nNode;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nNode = sc.nextInt();

        tree = new ArrayList[nNode+1];
        visited = new boolean[nNode+1];
        parent = new int[nNode+1];

        for(int i=1; i<=nNode; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<nNode; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        findingParent(1);

        for(int i=2; i<=nNode; i++){
            System.out.println(parent[i]);
        } 
    }

    public static void findingParent(int node){

        visited[node] = true;

        for(int i=0; i<tree[node].size(); i++){
            int sibling = tree[node].get(i);
            
            if(!visited[sibling]){
                parent[sibling] = node;
                findingParent(sibling);
            }
        }
    }
}
