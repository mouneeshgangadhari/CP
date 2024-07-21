 /*  You are given a list of unique individuals represented by positive integers 
in an array called nums. In this social network:

Each individual is represented by nums[i].
There is a relationship between individual nums[i] and individual nums[j] 
if they share a common interest greater than 1 (i.e., common factor).
The goal is to find the largest group of individuals who are connected 
through shared interests.

Input format
------------
An integer N, representing number of individuals
Space seperated N positive integers

Output format
-------------
An integer, number of individual in the largest group formed


Example 1:
----------
Input=
4
4 6 15 35
Output=
4

Example 2:
----------
Input=
4
20 50 9 63
Output=
2

Example 3:
----------
Input=
8
2 3 6 7 4 12 21 39
Output=
8
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 105
All the values of nums are unique.
*/

import java.util.*;
class LargestGroup
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.println(largestComponentSize(nums));
    }
    
    public static int largestComponentSize(int[] nums) {
        int maxNum = 100000;
        UnionFind uf = new UnionFind(maxNum + 1);
        
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        
        for (int num : nums) {
            List<Integer> primes = primeFactors(num);
            for (int prime : primes) {
                primeToIndices.computeIfAbsent(prime, k -> new ArrayList<>()).add(num);
            }
        }
        
        for (List<Integer> group : primeToIndices.values()) {
            for (int i = 1; i < group.size(); i++) {
                uf.union(group.get(0), group.get(i));
            }
        }
        
        int[] count = new int[maxNum + 1];
        int maxSize = 0;
        
        for (int num : nums) {
            int root = uf.find(num);
            count[root]++;
            maxSize = Math.max(maxSize, count[root]);
        }
        
        return maxSize;
    }
    
    public static List<Integer> primeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }
    
    static class UnionFind {
        int[] parent, rank;
        
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
