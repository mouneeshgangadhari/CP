/*
 * In a diamond mine There are n number of diamonds are available at some integer coordinates on a 2D plane.
Each coordinate point may have at most one diamond.
A diamond can be removed if it shares either the same row or the same column as another diamond that has not
been removed.

Given an array diamonds of length n where diamonds[i] = [xi, yi] represents the location of the ith diamond, 
return the largest possible number of diamonds that can be removed.

Note : use disjoint approach only

input format : an integer n
			    n number of integer pairs
output format : an integer 

Example 1:

Input= 6
0 0
0 1
1 0
1 2
2 1
2 2
Output=5
Explanation: One way to remove 5 diamonds is as follows:
1. Remove diamond [2,2] because it shares the same row as [2,1].
2. Remove diamond [2,1] because it shares the same column as [0,1].
3. Remove diamond [1,2] because it shares the same row as [1,0].
4. Remove diamond [1,0] because it shares the same column as [0,0].
5. Remove diamond [0,1] because it shares the same row as [0,0].
diamond [0,0] cannot be removed since it does not share a row/column with another diamond still on the plane.

Example 2:
Input=5
0 0
0 2
1 1
2 0
2 2
Output=3

Example 3:
Input=1
0 0
Output: 0

Constraints:
1 <= diamonds.length <= 1000
0 <= xi, yi <= 104
No two diamonds are at the same coordinate point.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class mining {
    public Map<Integer, Integer> parent;
    public Map<Integer, Integer> size;

    public mining() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    public int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            size.put(x, 1);
            return x;
        }
        if (parent.get(x) == x)
            return x;
        parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size.get(rootX) < size.get(rootY)) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent.put(rootY, rootX);
            size.put(rootX, size.getOrDefault(rootX, 0) + size.getOrDefault(rootY, 0));
        }
    }

    public static int help(int n, int[][] diamonds) {
        mining obj = new mining();

        for (int[] diamond : diamonds) {
            int x = diamond[0];
            int y = diamond[1];
            obj.union(x, y);
        }
        Set<Integer> s1 = new HashSet<>();
        for (int[] diamond : diamonds) {
            s1.add(obj.find(diamond[0]));
        }

        return n - s1.size();
    }

    public static void main(String v[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        System.out.println(help(n, a));

    }
}
