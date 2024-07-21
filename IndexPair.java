
/*
An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
kmec ngit colleges

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17
*/
import java.util.*;

class IndexPairs {
    public int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<int[]> result = new ArrayList<>();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            Trie node = trie;
            for (int j = i; j < n; j++) {
                char ch = text.charAt(j);
                if (node.children[ch - 'a'] == null) {
                    break;
                }
                node = node.children[ch - 'a'];
                if (node.end) {
                    result.add(new int[] { i, j });
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        Arrays.sort(res, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        return res;
    }
}

class Trie {
    Trie[] children;
    boolean end;

    public Trie() {
        end = false;
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }
        node.end = true;
    }
}

class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String org = sc.nextLine();
        String arr[] = sc.nextLine().split(" ");
        int res[][] = new IndexPairs().indexPairs(org, arr);
        for (int[] ans : res) {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
