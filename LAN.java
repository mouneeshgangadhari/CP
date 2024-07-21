/*
 * In your computer lab, network switches are connected using Ethernet cables to form a LAN. 
However, a new hardware technician inadvertently connected switches in a way that created a cycle,
resulting in a network loop. 
As a consequence, the network has become unstable. You need to identify and remove the specific cable that 
is causing the loop. 
If there are multiple cables contributing to the loop, you should remove the one that was most recently added

Example 1:
Input=3
0 1
0 2
1 2
Output=[1 2]

Example 2:
Input =5
0 1
1 2
2 3
0 3
0 4
Output=[0,3]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LAN {
    tatic int[] parent;
    static int[] rank;

    public static  int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static  void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rank[rootX]>rank[rootY])
        parent[rootY]=rootX;
        else if(rank[rootX]<rank[rootY])
            parent[rootX]=rootY;
        else{
            parent[rootX]=rootY;
            rank[rootY]+=1;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][2];
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            parent[i]=i;
            rank[i]=0;
        }
        List<int[]> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(find(a[i][0])==find(a[i][1])){
                int[] tmp={a[i][0],a[i][1]};
                al.add(tmp);

            }
            union(a[i][0],a[i][1]);
        }
        System.out.println(Arrays.toString(al.get(al.size()-1)));
    }
}
