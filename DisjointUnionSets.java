/*// Program to implement Disjoint Set Data Structure.
 input format :


*/
import java.io.*;
import java.util.*;
class DisjointUnionSets 
{
	int[] rank, parent;
	int n;
	public DisjointUnionSets(int n)
	{
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}
	// Creates n sets with single item in each
	void makeSet()
	{
		for (int i = 0; i < n; i++) {
			// Initially, all elements are in their own set
			parent[i] = i;
		}
	}
	// Returns representative of x's set
	int find(int x)
	{
		// Finds the representative of the set that x is an element of
		if (parent[x] != x) {
			System.out.println("x " + x + " parent[x] " + parent[x]);
			// if x is not the parent of itself then x is not the representative of his set
			parent[x] = find(parent[x]);
			// so we recursively call Find on its parent and move i's node directly under the
			// representative of this set
		}
		return parent[x];
	}
	// Unites the set that includes x and the set that includes x
	void union(int x, int y)
	{
		// Find representatives of two sets
		int xRoot = find(x), yRoot = find(y);
		System.out.println("x " + x + " xRoot " + xRoot + " y " + y + " yRoot " + yRoot);
		// Elements are in the same set, no need to unite anything.
		if (xRoot == yRoot)
			return;
		System.out.println("rank[xRoot] " + rank[xRoot] + " rank[yRoot] " + rank[yRoot]);
		// If x's rank is less than y's rank
		if (rank[xRoot] < rank[yRoot])
			// Then move x under y so that depth of tree remains less
			parent[xRoot] = yRoot;
		// else if y's rank is less than x's rank
		else if (rank[xRoot] > rank[yRoot])
			// Then move y under x so that depth of tree remains less
			parent[yRoot] = xRoot;
		else // if ranks are the same
		{
			// Then move y under x (doesn't matter which one goes where)
			parent[yRoot] = xRoot;
			// And increment the result tree's rank by 1
			rank[xRoot] = rank[xRoot] + 1;
		}
		for(int i = 0; i < n; i++)
			System.out.println("i " + i + " parent[i] " + parent[i] + " rank[i] " + rank[i]);
	}
}
class test 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		DisjointUnionSets dus =	new DisjointUnionSets(n);
		int r = sc.nextInt();
		for(int i = 0;i < r;i++)
		{
			int r1 = sc.nextInt();
			int r2 = sc.nextInt();
			dus.union(r1, r2);
		}
		int c = sc.nextInt();
		for(int i = 0;i < c;i++)
		{
			int f1 = sc.nextInt();
			int f2 = sc.nextInt();
			if(dus.find(f1) == dus.find(f2))
				System.out.println(f1 + " is a friend of " + f2);
			else
				System.out.println(f1 + " is not a friend of " + f2);
		}		
	}
}

/*
Example1 :
5 = number of friends
3 = number of relationships
2 = number of friendship check

input=5
3
0 2
4 2
3 1
2
4 0
1 0

output=	4 is a friend of 0
		1 is not a friend of 0
		

Example 2:
input=10
6
0 1
1 3
2 5
2 8
9 4
6 9
5
0 3
2 9
4 9
1 7
2 8

output= 0 is a friend of 3
		2 is not a friend of 9
		4 is a friend of 9
		1 is not a friend of 7
		2 is a friend of 8

*/