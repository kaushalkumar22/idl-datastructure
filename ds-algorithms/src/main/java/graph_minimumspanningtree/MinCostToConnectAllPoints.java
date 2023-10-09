package graph_minimumspanningtree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
 * where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
 * between any two points.
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 * Constraints:
 *
 *     1 <= points.length <= 1000
 *     -106 <= xi, yi <= 106
 *     All pairs (xi, yi) are distinct.
 */
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(points));
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.offer(new int[]{cost,i,j});
            }
        }
        int minCost = 0; //total cost for minimum spining tree
        int count =0;
        while(count<n-1) { // n - 1 if there are n vertices there must be n-1 edges.
            int[] top = pq.poll();
            int cost = top[0];
            int src =top[1];
            int dest = top[2];
            if(uf.find(src)==uf.find(dest)){
                continue;
            }
            minCost+=cost;
            count++;
            uf.union(src,dest);
        }
        return minCost;
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

