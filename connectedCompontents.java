import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class connectedCompontents {
    public List<Integer>[] adj;
    public boolean[] vis;

    public connectedCompontents(int n) {
        adj = new ArrayList[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

    }

    public void dfs(int i){
        vis[i]=true;
        for(int x:adj[i]){
            if(!vis[x])
                dfs(x);
        }
    }

    public void bfs(int x) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(x);
        vis[x] = true;
        while (!q1.isEmpty()) {
            int temp = q1.poll();
            List<Integer> t = adj[temp];
            for (int a : t) {
                if (!vis[a]) {
                    vis[a] = true;
                    q1.add(a);
                }
            }
        }
    }

    public int help(int[][] a, int n) {
        int c = 0;
        for (int[] x : a) {
            int u = x[0];
            int v = x[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(i);
                c++;
            }
        }
        return c;
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        connectedCompontents obj = new connectedCompontents(n);
        int[][] a = new int[e][2];
        for (int i = 0; i < e; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        System.out.println(obj.help(a, n));
    }
}
