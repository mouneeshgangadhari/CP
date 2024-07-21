/*
You have information about 'n' different gadgets. 
You are given a list of 'gadgets'. The 'i'th gadget has the name 'gadgets[i]', 
and you can build it if you have all the needed components 
where components of each gadget are provided.
You are also given a string array 'supplies' containing all the components 
that you initially have, and you have an infinite supply of all of them.
Components for a gadget may need to be assembled from other gadgets i.e.
may contain a string that is in 'gadgets'.

Return a list of all the gadgets that you can build.
Note that two gadgets may require each other in their components.

Input format
------------
Line 1: Space separated gadgets
Line 2: Space seperated supplies
next lines of input includes 'n' times the gadgets
number of components of a gadget say 'x'
'x' number of components of that gadget in each line

Output format
-------------
List of gadgets which can be assembled based on given input

Example 1:

Sample Input 1:
---------------
smartphone
screen processor camera
2
screen processor

Sample Output 1:
-----------------
[smartphone]

Explanation: We can build a "smartphone" since we have the components "screen" and "processor".


Example 2:

Input 2
--------
smartphone camera
screen processor lens
2
screen
processor
2
smartphone
lens

Output 2
---------
[smartphone, camera]

Explanation:
We can build a "smartphone" since we have the components "screen" and "processor".
We can build a "camera" since we have the component "lens" and can assemble the component "smartphone".

Note: All the values of 'gadgets' and 'supplies' combined are unique.

*/
import java.util.*;

class ListOfGadgets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String g[] = sc.nextLine().split(" "); // Gadgets
        String s[] = sc.nextLine().split(" "); // Supplies
        List<List<String>> al = new ArrayList<>();
        for (int i = 0; i < g.length; i++) {
            String n = sc.next();
            List<String> al1 = new ArrayList<>();
            for (int j = 0; j < Integer.parseInt(n); j++) {
                al1.add(sc.next());
            }
            al.add(al1);
        }
        System.out.println(find(g, al, s));
    }

    public static final int NOT_VISITED = 0;
    public static final int VISITING = 1;
    public static final int VISITED = 2;

    public static List<String> find(String gadgets[], List<List<String>> components, String supplies[]) {
        Map<String, Integer> status = new HashMap<>();
        Map<String, List<String>> prereqs = new HashMap<>();

        for (int i = 0; i < gadgets.length; ++i) {
            status.put(gadgets[i], NOT_VISITED);
            prereqs.put(gadgets[i], components.get(i));
        }

        for (String s : supplies) {
            status.put(s, VISITED);
        }

        List<String> output = new ArrayList<>();
        for (String g : gadgets) {
            dfs(g, prereqs, status, output);
        }

        return output;
    }

    public static boolean dfs(String g, Map<String, List<String>> prereqs, Map<String, Integer> status,
            List<String> output) {
        if (!status.containsKey(g)) {
            return false;
        }

        if (status.get(g) == VISITING) {
            return false;
        }

        if (status.get(g) == VISITED) {
            return true;
        }

        status.put(g, VISITING);
        for (String p : prereqs.get(g)) {
            if (!dfs(p, prereqs, status, output)) {
                return false;
            }
        }
        status.put(g, VISITED);
        output.add(g);

        return true;
    }
}


/* test cases

case=1
input=smartphone
screen processor camera
2
screen processor
output=[smartphone]

case=2
input=smartphone camera
screen processor lens
2
screen
processor
2
smartphone
lens

output=[smartphone, camera]

case=3
input=smartphone camera drone
screen processor lens propellers battery
2
screen
processor
2
smartphone
lens
3
camera
propellers
battery
output=[smartphone, camera, drone]

case=4
input=smartwatch microchip
screen battery transistors sensor
2
screen
battery
2
transistors
wiring
output=[smartwatch]


*/
