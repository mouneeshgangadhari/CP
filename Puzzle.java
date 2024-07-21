/*Mr. Balu is interested in solving puzzles. One puzzle involves a given number of nodes and unidirectional paths between these nodes. He needs to determine whether he can exit from puzzle or not. If at least one cycle can be formed with the given paths, then he cannot exit.

input format : two integers n and e
			   e number of integer pairs 
output format : Cycle_found or No_Cycle_Found

Example :1
input=12
11
0 1
0 6
0 7
1 2
1 5
2 3
2 4
7 8
7 11
8 9
10 11
output=No_Cycle_Found
Example 2:
input=12
12
0 1
0 6
0 7
1 2
1 5
2 3
2 4
7 8
7 11
8 9
9 10
10 11
Output=Cycle_Found
*/
import java.util.*;
class Edge
{
	int source, dest;
	public Edge(int source, int dest)
	{
		this.source = source;
		this.dest = dest;
	}
}
class Graph
{
	List<List<Integer>> adjList = null;
	Graph(List<Edge> edges, int n)
	{
		adjList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (Edge edge: edges) {
			adjList.get(edge.source).add(edge.dest);
		}
	}
}
class DisjointSet
{
	private Map<Integer, Integer> parent = new HashMap<>();
	int[] r;
	public void makeSet(int n)
	{
	    r=new int[n];
		for (int i = 0; i < n; i++) {
			parent.put(i, i);
			r[i]=0;
		}
	}
	public int find(int k)
	{
		//WRITE YOUR CODE HERE
		if(parent.get(k)==k){
		    return k;
		}
		parent.put(k,find(parent.get(k)));
		return parent.get(k);
	}
	public void union(int a, int b)
	{
	    // WRITE YOUR CODE HERE
	    int x_par=find(a),y_par=find(b);
	    if(x_par==y_par){
	        return ;
	    }
	    if(r[x_par]>r[y_par]){
	        parent.put(y_par,x_par);
	        r[x_par]++;
	    }
	    else{
	        parent.put(x_par,y_par);
	        r[y_par]++;
	    }
	}
}
class Puzzle
{
	public static boolean findCycle(Graph graph, int n)
	{
	    DisjointSet ds = new DisjointSet();
        ds.makeSet(n);
		for (int i = 0; i < n; i++) {
            List<Integer> neighbors = graph.adjList.get(i);
            for (Integer neighbor : neighbors) {
                int x = ds.find(i);
                int y = ds.find(neighbor);
                if (x == y)
                    return true;
                ds.union(x, y);
            }
		}
        return false;
		
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
		int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            edges.add(new Edge(source, destination));
        }
        Graph graph = new Graph(edges, n);
        if (findCycle(graph, n)) {
            System.out.println("Cycle_Found");
        } else {
            System.out.println("No_Cycle_Found");
        }
	}
}
