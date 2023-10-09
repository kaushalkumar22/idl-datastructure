package array_google;

import java.util.Arrays;

/**
 *
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {
    public static void main(String[] args) {
        int[][] nums ={{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};
        Arrays.sort(nums, (a,b)->Integer.compare(a[0],b[0]));
        System.out.println(earliestAcq(nums,4));
    }
    public static int earliestAcq(int[][] nums, int n) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int[] num : nums){
            if(uf.find(num[1])!=uf.find(num[2])){
                uf.union(num[1],num[2]);
                count --;
            }
            if(count==1) return num[0];
        }
        return -1;
    }

}
class UnionFind{

    private int[] parent ;
    private int[] rank ;
    int count ;
    public UnionFind(int n) {
        parent = new int[n+1];
        rank =  new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);    // path compression by halving
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int par1 = find(a);
        int par2 = find(b);
        if (rank[par1] > rank[par2]) {
            parent[par2] = par1;
            rank[par1]+=rank[par2];
        }else {
            parent[par1] = par2;
            rank[par2]+=rank[par1];
        }
    }
}
