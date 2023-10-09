package graph_minimumspanningtree;

import java.util.Arrays;

/**
 * There are N cities numbered from 1 to N.
 *
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1
 * and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 *
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1)
 * that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
 *
 *
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 *
 *
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 */

public class ConnectingCitiesWithMinimumCost {

    public static void main(String[] args) {
        int[][] points = {{1,2,5},{1,3,6},{2,3,1}};
        int n =3;
        System.out.println(new ConnectingCitiesWithMinimumCost().minimumCost(n,points));
    }
    public int minimumCost(int n,int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2]-b[2]);

        int res = 0;
        int count =n;
        UnionFind uf = new UnionFind (n+1);
        for(int [] connect : connections){
            if(uf.find(connect[0]) != uf.find(connect[1])){
                uf.union(connect[0], connect[1]);
                res += connect[2];
                count--;
            }
        }
        return count==1?res:-1;
    }

    static class UnionFind{
        int[] parent;
        int[] rank;
        UnionFind(int n){
            parent= new int[n];
            rank = new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }
        int find(int x){
            if(x!=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        void union(int a , int b){
            int p1 =find(a);
            int p2 =find(b);
            if(rank[p1]>rank[p2]){
                parent[p2]=p1;
                rank[p1]+=rank[p2];
            }else{
                parent[p1]=p2;
                rank[p2]+=rank[p1];
            }
        }
    }
}

