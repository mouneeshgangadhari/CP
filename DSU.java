import java.util.*;

public class DSU {
    static int[] parent;
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
