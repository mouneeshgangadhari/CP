/*
A kid is playing with magnetic balls and arrow sticks. He has n balls which
are labeled from 0 to n - 1. He wants to connect balls with given arrow sticks. Each array is red or blue, and there could be self-arrows and parallel arrows.
You are given two arrays redArrows and blueArrows where:

redArrows[i] = [ai, bi] indicates that there is a directed red arrow from ball ai to ball bi in the game, and
blueArrows[j] = [uj, vj] indicates that there is a directed blue arrow from ball uj to ball vj in the game.
Return an array answer of length n, where each answer[x] is the length of the shortest path from ball 0 to ball x such that the arrow colors alternate along the path, or -1 if such a path does not exist.

Input format
------------
Three integers N, P and Q. Where N represents number of balls, P represnts number of redArrows and Q represents number of blueArrows
Next P lines, 2 integers in each line representing redArrows
Next Q lines, 2 integers in each line representing blueArrows

Output format
-------------
Result array

Example 1:
-----------
Input=
3 2 0
0 1
1 2
Output=
[0, 1, -1]

Example 2:
----------
Input=
3 1 1
0 1
2 1
Output=
[0, 1, -1]

Constraints:

1 <= n <= 100
0 <= redArrows.length, blueArrows.length <= 400
0 <= ai, bi, uj, vj < n
*/
import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redArrows, int[][] blueArrows) {

        ArrayList<ArrayList<Integer>>adjRed=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adjBlue=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjRed.add(new ArrayList<>());
            adjBlue.add(new ArrayList<>());
        }

        for(int i=0;i<redArrows.length;i++){
            adjRed.get(redArrows[i][0]).add(redArrows[i][1]);
        }
        for(int i=0;i<blueArrows.length;i++){
            adjBlue.get(blueArrows[i][0]).add(blueArrows[i][1]);
        }

        int visit[][]=new int[n][2];
        int ans[]=new int[n];
        Arrays.fill(ans,-1);

        Queue<Pair>q=new LinkedList<>();

        if(adjRed.get(0)==null){}
        q.add(new Pair(0,0));
        q.add(new Pair(0,1));

        visit[0][0]=0;//0 means red
        visit[0][1]=1;//1 means blue;

        ans[0]=0;
        int level=1;
        while(!q.isEmpty()){
            int len=q.size();
            while(len-->0){
                Pair pt=q.poll();
                int ball=pt.first;
                int colorUsed=pt.second;
                if(colorUsed==0){
                    for(int e:adjRed.get(ball)){
                        if(visit[e][0]==0){
                            q.add(new Pair(e,1));
                            visit[e][0]=1;
                            if(ans[e]==-1) ans[e]=level;
                        }
                    }
                }

                else{
                    for(int e:adjBlue.get(ball)){
                        if(visit[e][1]==0){
                            q.add(new Pair(e,0));
                            visit[e][1]=1;
                            if(ans[e]==-1) ans[e]=level;
                        }
                    }
                }
            }
            level++;
        }

        return ans;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n,p,q,i,j;
		n=sc.nextInt();
		p=sc.nextInt();
		q=sc.nextInt();
		int redArrows[][]=new int[p][2];
		int blueArrows[][]=new int[q][2];
		for(i=0;i<p;i++)
			for(j=0;j<2;j++)
				redArrows[i][j]=sc.nextInt();
		for(i=0;i<q;i++)
			for(j=0;j<2;j++)
				blueArrows[i][j]=sc.nextInt();
		System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(n,redArrows,blueArrows)));
	}
}
/* Test cases
case=1
Input=
3 2 0
0 1
1 2
Output=
[0, 1, -1]

case=2
Input=
3 1 1
0 1
2 1
Output=
[0, 1, -1]

case=3
Input=5 3 2
1 2
3 2
0 1
4 3
1 4
Output=
[0, 1, -1, -1, 2]

case=4
Input=6 3 3
0 1
2 3
4 5
1 2
3 4
5 0
Output=
[0, 1, 2, 3, 4, 5]

*/