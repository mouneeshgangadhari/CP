/*
 * /*
Sridhar brought his latest Apple iPhone 15 pro. He started his conversation 
with one of his friend on WhatsApp with list of words.

Now it’s our task to find and return what are the most common words 
in the list of words he used in sorted order based on occurrence from 
largest to smallest. If any of words he used are having same occurrence 
then consider the lexicographic order.

You will be given a list of words, you need to print top P number of 
most common used words as described in the statement. 

Input Format:
-------------
Line-1: comma separated line of words, list of words.
Line-2: An integer P, number of words to display. 

Output Format:
--------------
Print P number of most common used words.


Sample Input-1:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
3

Sample Output-1:
----------------
[are, case, egg]



Sample Input-2:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
3

Sample Output-2:
----------------
[are, egg, case]


*/

import java.util.*;

class Node {
    public char c;
    public boolean isWord;
    public int count;
    public Node[] children;
    public String str;

    public Node(char c) {
        this.c = c;
        this.isWord = false;
        this.count = 0;
        children = new Node[26];
        str = "";
    }
}

class Trie {
    public Node root;

    public Trie() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(word.charAt(i));
            }
            curr = curr.children[idx]; // Update curr instead of root
        }
        curr.isWord = true;
        curr.str = word;
        curr.count++;
    }

    public void traverse(Node root, PriorityQueue<Node> pq) {
        if (root == null)
            return;
        if (root.isWord) {
            pq.offer(root);
        }
        for (Node x : root.children) {
            traverse(x, pq);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int p = sc.nextInt();
        String[] words = line1.split(",");
        Trie t = new Trie();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.count != b.count) {
                    return Integer.compare(b.count, a.count);
                } else {
                    return a.str.compareTo(b.str);
                }
            }
        });
        for (String x : words) {
            t.insert(x);
        }
        t.traverse(t.root, pq);
        List<String> res = new ArrayList<>();
        int k = 0;
        while (k++ < p && !pq.isEmpty()) {
            res.add(pq.poll().str);
        }
        System.out.println(res);

    }
}
