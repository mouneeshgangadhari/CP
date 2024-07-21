
/*
you are given a binary matrix of size nxn .Your task is to find duplicate rows present in a given matrix by traversing the matrix only once.

For example,

Input=5
1  0  0  1  0
0  1  1  0  0
1  0  0  1  0
0  0  1  1  0
0  1  1  0  0
Output=3 5 
Explanation: Row #3 is duplicate of row #1 and row #5 is duplicate of row #2
*/
// A class to store a Trie node
import java.util.*;

class Trie {
    boolean isLeaf; // set when the node is a leaf node
    Trie[] character = new Trie[2];

    // Constructor
    Trie() {
        isLeaf = false;
    }
}

class DuplicateRows {
    // Iterative function to insert each array element into a Trie
    public static boolean insert(Trie head, int[] A) {
        // WRITE YOUR CODE HERE
        Trie curr = head;
        boolean isNewRow = false;

        // Traverse through the Trie
        for (int i = 0; i < A.length; i++) {
            int index = A[i];
            if (curr.character[index] == null) {
                // If the current character is not present in Trie, create a new node
                curr.character[index] = new Trie();
                isNewRow = true; // This row is unique so far
            }
            curr = curr.character[index];
        }

        // If the row is already present in Trie, return false
        if (curr.isLeaf) {
            return false;
        }

        // Mark the current node as a leaf node
        curr.isLeaf = true;

        return isNewRow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie head = new Trie();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        // insert all rows of the matrix into a Trie
        for (int i = 0; i < n; i++) {
            if (!insert(head, mat[i])) {
                System.out.print(" " + (i + 1));
            }
        }
    }
}
