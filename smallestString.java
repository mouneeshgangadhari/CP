
/*
 * Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"

 */
import java.util.Scanner;

public class smallestString {
    public String smallestEquivalentString(String A, String B, String S) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < A.length(); ++i) {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(i) - 'a';
            uf.union(a, b);
        }

        // kmit ngit mgit

        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            sb.append((char) ('a' + uf.find(ch - 'a')));
        }
        return sb.toString();
    }

    class UnionFind {
        int[] parent = new int[26];

        UnionFind() {
            for (int i = 0; i < 26; ++i)
                parent[i] = i;
        }

        int find(int a) {
            if (a != parent[a]) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            System.out.println("a " + a + " b " + b + " parentA " + parentA + " parentB " + parentB);

            if (parentA == parentB)
                return;

            if (parentA < parentB)
                parent[parentB] = parentA;
            else
                parent[parentA] = parentB;
        }
    }
}

public class SmallestString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String T = sc.next();
        System.out.println(new Solution().smallestEquivalentString(A, B, T));
    }
}
