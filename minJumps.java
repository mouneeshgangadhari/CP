/*Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

	i + 1 where: i + 1 < arr.length.
	i - 1 where: i - 1 >= 0.
	j 
where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: 10
100 -23 -23 404 100 23 23 23 3 404
Output=3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Example 2:
Input=1
7
Output: 0
Explanation: Start index is the last index. You do not need to jump.

Example 3:
Input=8
7 6 9 6 9 6 9 7
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
 Constraints:
1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class minJumps {
    public static int help(int[] a, int n) {
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(0);
        vis[0] = true;
        int res = 0;
        while (!q1.isEmpty()) {
            int size = q1.size();
            while (size-- > 0) {
                int cur = q1.poll();
                if (cur == n - 1)
                    return res;
                if (cur + 1 < n && !vis[cur + 1]) {
                    q1.add(cur + 1);
                    vis[cur + 1] = true;
                }
                if (cur - 1 >= 0 && !vis[cur - 1]) {
                    q1.add(cur - 1);
                    vis[cur - 1] = true;
                }
                for (int j = 0; j < n; j++) {
                    if (a[cur] == a[j] && cur != j && !vis[j]) {
                        q1.add(j);
                        vis[j] = true;
                    }
                }
            }
            res++;
        }
        return res;

    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(help(a, n));
    }
}