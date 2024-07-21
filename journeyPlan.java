/*
 * Mr. X want to travel all the cities in a state. 
Plan a journey, including the route and all the cities that exist.
You need to find a route between source and destination which will cover all the cities. 
Source and destination can be any city among given cities.
He should not visit any city more than once.

Input format
------------
An integer N which determine number of direct routes.
In the next N lines, input existing direct routes between every two cities.

Note: Input should guarantee a route which covers all the cities

Output Format
-------------
Source to destination route

Example 1:
----------
input=
3
KNG RGM
WGL KNG
HYD WGL
output=
HYD-WGL-KNG-RGM

Example 2:
----------
input=
4
LAX DXB
DFW JFK
LHR DFW
JFK LAX
output=
LHR-DFW-JFK-LAX-DXB

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class journeyPlan {
    public  Map<String, List<String>> graph = new HashMap<>();
    public Map<String, Integer> degree = new HashMap<>();

    public List<String> help() {
        String start = null;
        for (String city : degree.keySet()) {
            if (degree.get(city) % 2 == 1) {
                start = city;
                break;
            }
        }

        if (start == null) {
            start = graph.keySet().iterator().next();
        }

        List<String> path = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String v = stack.peek();
            if (!graph.get(v).isEmpty()) {
                String u = graph.get(v).remove(graph.get(v).size() - 1);
                graph.get(u).remove(v);
                stack.push(u);
            } else {
                path.add(stack.pop());
            }
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        journeyPlan journeyPlan = new journeyPlan();
        
        for (int i = 0; i < N; i++) {
            String[] route = sc.nextLine().split(" ");
            String city1 = route[0];
            String city2 = route[1];

            journeyPlan.graph.putIfAbsent(city1, new ArrayList<>());
            journeyPlan.graph.putIfAbsent(city2, new ArrayList<>());
            journeyPlan.graph.get(city1).add(city2);
            journeyPlan.graph.get(city2).add(city1);

            journeyPlan.degree.put(city1, journeyPlan.degree.getOrDefault(city1, 0) + 1);
            journeyPlan.degree.put(city2, journeyPlan.degree.getOrDefault(city2, 0) + 1);
        }

        List<String> path = journeyPlan.help();
        StringBuilder str = new StringBuilder();
        for (String city : path) {
            str.append(city).append("-");
        }

        if (str.length() > 0) {
            str.setLength(str.length()-1);
        }

        System.out.println(str);
    }
}
