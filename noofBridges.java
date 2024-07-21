/*


In the magical world of Harry Potter, there are N enchanted locations, each identified by a unique number from 1 to N. These locations are interconnected by mystical, bidirectional pathways that allow witches and wizards to travel between them.
You are a young wizard starting your journey at location 1, and your goal is to reach the final destination, location N. Along the way, you will need to traverse several pathways, but to make the journey more challenging, you aim to use the minimum number of pathways possible.

you will be given number of locations, number of pathways. you need to return how many pathways need to cross. If N is unreachable then return -1.

input format : two integers N and E
			   E number of integer pairs
output format : an integer
					

Example1:
Input= 3
2
1 2
2 3
output=2
Explanation: 
To reach Node 2 from Node 1, 1 bridge is required to be crossed. 
To reach Node 3 from Node 2, 1 bridge is required to be crossed.
Hence, 2 bridges are required to be connected.

Example 2:
Input=4
3
1 2
2 3
2 4
Output=2

*/
import java.util.*;
class Test
	{
		static ArrayList<Integer>[] g;
		static int[] vis;
		static int[] dist;
		static void init(int N){
			g = new ArrayList[N + 1];
			vis = new int[N + 1];
			dist = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				g[i] = new ArrayList<>();
        }
				}
		static void BFS(int src)
			{
				Queue<Integer> q = new LinkedList<>();
				q.add(src);
				vis[src] = 1;
				dist[src] = 0;
				while (!q.isEmpty()) {
					int curr = q.peek();
					q.remove();
					for (int child : g[curr]) {
						if (vis[child] == 0) {
							q.add(child);
							dist[child] = dist[curr] + 1;
							vis[child] = 1;
						}
					}
				}
			}
	static void buildGraph(int M, int arr[][])
		{
			for (int i = 0; i < M; i++) {
					g[arr[i][0]].add(arr[i][1]);
					g[arr[i][1]].add(arr[i][0]);
			}
		}
	static void shortestDistance(int N, int M, int arr[][])
		{
			init(N);
			buildGraph(M, arr);
			dist[N]=-1;
			BFS(1);
			
		}
	public static void main(String[] args)
		{
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[M][2];
			for(int i=0;i<M;i++){
				arr[i][0]=sc.nextInt();
				arr[i][1]=sc.nextInt();
			}
			shortestDistance(N, M, arr);
			System.out.println(dist[N]);
		}
}
/*
case =1
input=5
5
1 2
1 3
2 4
3 4
4 5
output=3
case =2
input=5
4
1 2
1 3
2 4
3 4
output=-1
case =3
input=3
2
1 2
2 3
output=2
case =4
input=4
3
1 2
2 3
2 4
Output=2
case =5
input=6
6
1 2
2 3
3 6
1 4
4 5
5 6
output=3
*/