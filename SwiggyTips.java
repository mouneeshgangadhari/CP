/*


Swiggy delivery boy exists a map with n locations starting from 0 to n-1.
You are given an integer n and paths of lengths n-1, 
where each path has 2 values [a,b] which indicates that there is a path between
location a and location b in the map.
You are also given an array of tips of size n where tips[i] can be either 0
or 1, where 1 indicates he gets the tip at that location i.

As he was greedy, he only want to delivery to the location where he can receive some tips.

Initially, Swiggy boy choose to start at any location in the map. Then, he can perform the following operations any number of times: 

Collect all the tips that are at a distance of at most 2 from the current location, 
or move to any adjacent location in the map.

Your task to help swiggy boy to find the minimum number of paths he need to go through to collect all the tips and go back to the initial location.

Note that if he passes a path several times, you need to count it into the answer several times.

Input Format:
-------------
Line-1: An integer N, number of locations.
Line-2: An array of tips, n seperated values.
Next N-1 lines: Two space separated integers, a and b.

Output Format:
--------------
An integer, the minimum number of paths.


Example 1:

Sample input 1
---------------
6
1 0 0 0 0 1
0 1
1 2
2 3
3 4
4 5

Sample output 1
---------------
2


Explanation: Start at location 2, collect the coin at location 0, move to location 3, collect the coin at location 5 then move back to location 2.

Example 2:

Sample input 2
--------------
8
0 0 0 1 1 0 0 1
0 1
0 2
1 3
1 4
2 5
5 6
5 7

Sample output 2
----------------
2

Explanation: Start at location 0, collect the coins at vertices 4 and 3, move to location 2,  collect the coin at location 7, then move back to location 0.

*/
import java.util.*;
class Solution {
    public int collectTheTips(int[] tips, int[][] paths) {
        int n = tips.length;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());

        int degree[] = new int[n];
        
        for(int i = 0; i < paths.length; i++) {
            int a = paths[i][0];
            int b = paths[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
            degree[a]++;
            degree[b]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < degree.length; i++) {
            if ( degree[i] == 1 && tips[i] == 0) {
                q.add(i);
            }
        }

        Set<Integer> deleteNode = new HashSet<Integer>();

        int current;
        while(!q.isEmpty()) {
            current = q.poll();
            deleteNode.add(current);

            int childNode;
            for(int i = 0; i < graph.get(current).size(); i++) {
                childNode = graph.get(current).get(i);
                degree[childNode]--;
                if ( degree[childNode] == 1 && tips[childNode] == 0){
                    q.add(childNode);
                }
            }
        }

    
        for(int i = 0; i < n; i++) graph.get(i).clear();;
        Arrays.fill(degree, 0);
        for(int i = 0; i < paths.length; i++) {
            int a = paths[i][0];
            int b = paths[i][1];

            if ( deleteNode.contains(a) || deleteNode.contains(b)) continue;
            graph.get(a).add(b);
            graph.get(b).add(a);
            degree[a]++;
            degree[b]++;
        }

        boolean visit[] = new boolean[n];
        for(int i = 0; i < degree.length; i++) {
            if ( degree[i] == 1 ) {
                deleteNode.add(i);
                int parentNode ;
                for(int j = 0; j < graph.get(i).size(); j++) {
                    parentNode = graph.get(i).get(j);
                    if ( visit[parentNode]) continue;
                    visit[parentNode] = true;
                    int childNode;
                    boolean isDelete = true;
                    int count = 0;
                    for(int a = 0; a < graph.get(parentNode).size(); a++) {
                        childNode = graph.get(parentNode).get(a);
                        if ( degree[childNode] != 1 ) {
                            count++;
                            if ( count > 1) {
                                isDelete = false;
                                break;
                            }
                        }
                    }

                    if ( isDelete ) deleteNode.add(parentNode);
                    
                }
            }
        }
        return Math.max(0, (n-deleteNode.size()-1) * 2);
    }
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		String values[]=sc.nextLine().split(" ");
		int[][] paths=new int[n-1][2];
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<2;j++)
				paths[i][j]=sc.nextInt();
		}
		
		int tips[]=new int[n];
		for(int i=0;i<values.length;i++)
			tips[i]=Integer.parseInt(values[i]);
        System.out.println(new Solution().collectTheTips(tips,paths));
	}
}
/* 
test cases

case=1
input=6
1 0 0 0 0 1
0 1
1 2
2 3
3 4
4 5
output=2

case=2
input=8
0 0 0 1 1 0 0 1
0 1
0 2
1 3
1 4
2 5
5 6
5 7
output=2

case=3
input=9
1 0 1 0 0 1 0 0 1
0 1
1 2
2 3
3 4
4 5
5 6
6 7
7 8
output=8

case=4
input=7
1 0 1 0 1 0 1
0 1
1 2
2 3
3 4
4 5
5 6
output=4

*/