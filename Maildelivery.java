/*
 * You are given a Gated community of N villas, labeled from 1 to N. 
You are also given times, a list of travel times as directed paths 
times[i] = (ui, vi, wi), where ui is the source villa, vi is the target villa, 
and wi is the time taken for a person to travel from source to target.

We will send post man from a given villa k. Return the minimum time post man 
takes for all the N villas to deliver the mails. If it is impossible for the 
post man to deliver mails to all the N villas then return -1.

Input format
------------
An integer, represents N
An integer M, represents number of path ways
Next M lines, 3 integers each line representing ui,vi and wi of each path
An integer, represents K

Output format
-------------
An integer, represents minimum time or -1

Example 1
---------
Input=
4
3
2 1 1
2 3 1
3 4 1
2

Output=
2

Example 2:
----------
Input=
2
1
1 2 1
1

Output=
1

Example 3:
----------
Input=
2
1
1 2 1
2
Output=
-1


Constraints:

1 <= k <= N <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= N
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple paths.)


 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Maildelivery {
    public static int minDeliveryTime(int N, int M, int[][] times, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{K, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(K, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], time = current[1];

            if (time > dist.getOrDefault(node, Integer.MAX_VALUE)) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];
                int newDist = time + weight;
                if (newDist < dist.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    dist.put(nextNode, newDist);
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }
        if (dist.size() != N) {
            return -1;
        }
        int maxTime = 0;
        for (int d : dist.values()) {
            maxTime = Math.max(maxTime, d);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] times = new int[M][3];
        for (int i = 0; i < M; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
            times[i][2] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(minDeliveryTime(N, M, times, K));
    }
}
