/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output:
--------------
75
86
80

8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7


16 1
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
1 0 15		

*/

import java.util.*;

class FenWickTree {
	int[] nums;
	int[] BIT;
	int n;

	// Function to construct fenwick tree from given array
	public FenWickTree(int[] nums) 
	{
		this.nums = nums;

		n = nums.length;
		BIT = new int[n + 1];
		for (int i = 0; i < n; i++)
		{
			//System.out.println("for " + i);
			init(i, nums[i]);
			// for (int j = 0; j <= n; j++)
				//System.out.println("BITS after " + j + " " + BIT[j]);
		}

		for (int i = 0; i <= n; i++)
			System.out.println("BITS " + i + " " + BIT[i]);
	}

	/*

	Note that the init(i, val) operation will not change arr[]. 
	It only makes changes to BIT[] 
	1) Initialize the current index as i+1. 
	2) Do the following while the current index is smaller than or equal to n. 
		a) Add the val to BIT[index] 
		b) Go to next element of BIT[index]. This will give the ancestors of tree
		The next element is obtained by incrementing the last set bit of the 
		current index, i.e., index = index + (index & (-index))
	*/

	public void init(int i, int val) {
		System.out.println("Init i " + i + " val " + val);
		i++;
		// Traverse all ancestors and add 'val'
		while (i <= n) {
			BIT[i] += val;
			System.out.println("Init i " + i + " val " + val + " BIT[" + i + "] " + BIT[i]);
			// Update index to that of parent
			i += (i & -i);
			//System.out.println("Init i after " + i);
		}
	}

	void update(int i, int val) {
		int diff = val - nums[i];
		System.out.println("Update i " + i + " val " + val + " nums[i] " + nums[i] + " Diff " + diff);
		nums[i] = val;
		init(i, diff);
		System.out.println("After update");
		for (int k = 0; k <= n; k++)
			System.out.println("Updated Bits " + k + " " + BIT[k]);

	}

	/*
	getSum(i): Returns the sum of the sub-array arr[0,...,x] 
	Returns the sum of the sub-array arr[0,...,x] using BIT[0..n], which is constructed from arr[0..n-1] 
	1) Initialize the output sum as 0, the current index as i+1. 
	2) Do following while the current index is greater than 0. 
		a) Add BIT[index] to sum 
		b) Go to the parent of BIT[index]. The parent can be obtained by removing 
		the last set bit from the current index, i.e. index = index - (index & (-index)) 
	3) Return sum
	*/

	public int getSum(int i) 
	{
		int sum = 0;
		i++;
		while (i > 0) 
		{
			// Add current element of BIT to sum
			sum += BIT[i];
			System.out.println("getSum i " + i + " sum " + sum + " BIT[" + i + "] " + BIT[i]);

			// Move index to parent node
			i -= (i & -i);
			System.out.println("getSum i after " + i);
		}
		System.out.println("sum " + sum);
		return sum;
	}

	public int sumRange(int i, int j) 
	{
		System.out.println("sumRange i " + i + " j " + j);
		return getSum(j) - getSum(i - 1);
	}
	
	public static void main(String args[] ) {
		 Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int q=scan.nextInt();      
		int[] nums=new int[n];
		for(int i=0; i<n; i++)
		{
			 nums[i] = scan.nextInt();
		}
		FenWickTree ft =new FenWickTree(nums);
		while(q-->0){
			int opt=scan.nextInt();
			if(opt==1){
				int s1 = scan.nextInt();
				int s2 = scan.nextInt();
				System.out.println(ft.sumRange(s1,s2));
			}
			else{
				int ind = scan.nextInt();
				int val= scan.nextInt();
				ft.update(ind,val);
			}
		}
	}
}