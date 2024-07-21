/*
In a vibrant artistic community, there are several individuals who excel in different forms of art. Each person has a unique level of creativity (measured by their "artistic score") and a different amount of wealth. The community members support each other, and it is known that if person A has more wealth than person B, then A will definitely support B in their artistic endeavors.

You are given two arrays:

1. 'wealthier': An array of pairs '[ai, bi]', where 'ai' has more wealth than 'bi'.
2. 'artistic_scores': An array representing the artistic scores of each person.

Your task is to determine the least creative person (i.e., the person with the lowest artistic score) among all individuals who definitely have equal to or more wealth than a given person 'x'.

Return an integer array 'answer' where 'answer[x] = y' if person 'y' is the least creative among those who have equal to or more wealth than person 'x'.

Input format
------------
An integer represents number of wealthier pairs, Say M
Next M lines represent the space seperated pairs: ai and bi
Space seperated artistic_scores

Output format
-------------
answer array


Sample Input 1
---------------
7
1 0
2 1
3 1
3 7
4 3
5 3
6 3
3 2 5 4 6 1 7 0

Sample output 1
----------------
[5, 5, 2, 5, 4, 5, 6, 7]

Explanation:
- 'answer[0] = 5': Person 5 has more wealth than 3, which has more wealth than 1, which has more wealth than 0. The only person who is less creative (has a lower artistic score) than person 0 is person 7, but it is not clear if they have more wealth than person 0.
- 'answer[7] = 7': Among all people who definitely have equal to or more wealth than person 7 (which could be persons 3, 4, 5, 6, or 7), the person who is the least creative (has the lowest artistic score) is person 7.


Sample Input 2
---------------
7
1 0
2 1
3 1
4 3
5 3
6 3
7 6
10 8 12 6 15 5 18 3

Sample output 2
----------------
[7, 7, 2, 7, 4, 5, 7, 7]

Constraints:
n == artistic_scores.length
1 <= n <= 500
0 <= quiet[i] < n
All the values of artistic_scores are unique.
0 <= wealthier.length <= n * (n - 1) / 2
0 <= ai, bi < n
ai != bi
All the pairs of wealthier are unique.
The observations in wealthier are all logically consistent.

*/
import java.util.*;
class Solution {
    public void dfs(int node, boolean[] visited, List<Integer>[] adj, Stack<Integer> st) {
        visited[node] = true;
        for (int child : adj[node]) {
            if (!visited[child]) {
                dfs(child, visited, adj, st);
            }
        }
        st.push(node);
    }

    public int[] artisticAndWealth(int[][] wealthier, int[] scores) {
        int n = scores.length;
        int[] ans = new int[n];
        Stack<Integer> order = new Stack<>();
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            ans[i] = i;
            adj[i] = new ArrayList<>();
        }

        for (int[] vec : wealthier) {
            adj[vec[0]].add(vec[1]);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, order);
            }
        }

        while (!order.isEmpty()) {
            int node = order.pop();
            for (int child : adj[node]) {
                if (scores[ans[child]] > scores[ans[node]]) {
                    ans[child] = ans[node];
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] wealthier=new int[n][2];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<2;j++)
				wealthier[i][j]=sc.nextInt();
		}
		sc.nextLine();
		String values[]=sc.nextLine().split(" ");
		int scores[]=new int[values.length];
		for(int i=0;i<values.length;i++)
			scores[i]=Integer.parseInt(values[i]);
		Solution obj=new Solution();
        System.out.println(Arrays.toString(obj.artisticAndWealth(wealthier,scores)));
	}
}
/*
Test cases

Case=1
input=7
1 0
2 1
3 1
3 7
4 3
5 3
6 3
3 2 5 4 6 1 7 0
output=[5, 5, 2, 5, 4, 5, 6, 7]

case=2
input=7
1 0
2 1
3 1
4 3
5 3
6 3
7 6
0 2 3 1 4 7 6 5
output=[0, 3, 2, 3, 4, 5, 7, 7]

case=3
input=7
1 0
2 1
3 1
4 3
5 3
6 3
7 6
3 6 7 1 2 0 5 4
output=[5, 5, 2, 5, 4, 5, 7, 7]

case=4
input=8
1 0
2 1
3 1
4 3
5 3
6 3
7 6
8 7
7 6 3 4 8 0 1 5 2
output=[5, 5, 2, 5, 4, 5, 6, 8, 8]
*/

