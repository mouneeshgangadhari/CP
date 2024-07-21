/*
 * Input an array of distinct numbers, and you can perform the following operations until the array is empty:

If the first element has the smallest value, remove it
Otherwise, put the first element at the end of the array.

Return an integer denoting the number of operations it takes to make nums empty.

Example 1:
Input: 3 4 -1
Output: 5
Operation	Array
1			[4, -1, 3]
2			[-1, 3, 4]
3			[3, 4]
4			[4]
5			[]

Example 2:
Input: 1 2 4 3
Output: 5
Operation	Array
	1		[2, 4, 3]
	2		[4, 3]
	3		[3, 4]
	4		[4]
	5		[]

Example 3:
Input: 1 2 3
Output: 3
Operation	Array
	1		[2, 3]
	2		[3]
	3		[]
 
Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
All values in nums are distinct.
 */

import java.util.*;

public class stepsToEmptyList {
	public static int help(int[] arr) {
		Queue<Integer> pq = new LinkedList<>();
		for (int num : arr) {
			pq.offer(num);
		}
		Arrays.sort(arr);
		int min = 0;
		int count = 0;
		while (!pq.isEmpty()) {
			int front = pq.poll();
			if (front == arr[min]) {
				min++;
			} else {
				pq.offer(front);
			}
			count++;
		}
		return count;

	}

	public static void main(String v[]) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int[] a = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		System.out.println(help(a));
	}
}
