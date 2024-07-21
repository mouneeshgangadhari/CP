/*
 * Tata motors released a new ELECTRIC CAR, which recharges its battery based on 
the vehicle movement at specific points along the road when vehicle passes 
those points at a specified speed. 
As you are the owner of that CAR, you want to get maximum benefit of that, 
and you are travelling on a road of length "N" kilometres. 
There are specific recharge points at every kilometre, it specifies 
how much percentage of battery improves when you pass those points with 
a specified speed. But you can travel with this specified speed for 
a continuous distance of "K" kilometres. With your programming skills, 
can you determine how to maximize the benefit from this.


input format:
First line contains two space-separated integers N and K, 
the length of the track and the maximum distance car can run at specified speed.

Second line contains N space-separated integers, 
the number of charging points within each kilometre of the road.

Output an integer.


Sample 1:
Input=7 2
2 4 8 1 2 1 8
output=12
Explanation:
Car can get maximum recharge 4+8=12 if it runs at specified speed between 
the 2nd and the 3rd kilometre, inclusive.

Constraints 
1≤T≤10
1≤K≤N≤100
1≤ai≤100

You may use the following java code segement to solve this problem

import java.util.Scanner;

class main 
{
    public int carRecharge(int[] ChPoints,int k,int N)
	{
		//WRITE YOUR CODE HERE
	}     
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);       
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[] ChPoints = new int[N];
		for (int i = 0; i < N; i++) {
			ChPoints[i] = scanner.nextInt();
		}
		System .out.println(new main().carRecharge(ChPoints,K,N));
	}
       
}


 */
public class carReacharge {
    public int carRecharge(int[] ChPoints, int k, int N) {
        // WRITE YOUR CODE HERE
        int max = Integer.MIN_VALUE;
        int c = 0;
        for (int i = 0; i < k; i++) {
            c = c + ChPoints[i];
        }
        max = Math.max(max, c);
        for (int i = k; i < N; i++) {
            c = c - ChPoints[i - k] + ChPoints[i];
            max = Math.max(max, c);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] ChPoints = new int[N];
        for (int i = 0; i < N; i++) {
            ChPoints[i] = scanner.nextInt();
        }
        System.out.println(new carReacharge().carRecharge(ChPoints, K, N));
    }
}
