
/*
 * The following are the options 
1. Insert 
2. Search
3. Delete
4. Display 
5 exit
input format : First line of input is space separated words
               second line onwords, options followed by concerned input(if required) 
			   last line of input should have 5(to exit)
Example 1:
input =input=abc def ghi
4				// display trie
1				// insert into trie
pqr				// word to be inserted
2				// search trie
abc				// word to be searched
1				// insert into trie
mno				// word to be inserted
3				// delete form trie
abc				// word to be dleted
5				// exit

input =abc def ghi
4
1
pqr
2
abc
1
mno
3
abc
5

Example 2:
input = kmit ngit
4
1
kmec
1
kmce
2
kmec
2
kmit
3
kmec
5

Use this Java code segment to solve
*/
import java.util.*;

class trie {
	static final int NUM_CHARS = 26;
	static boolean isDeleted = false;

	static class TrieNode {
		TrieNode[] children = new TrieNode[NUM_CHARS];
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < NUM_CHARS; i++)
				children[i] = null;
		}
	};

	static TrieNode root;

	static void insert(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode currentNode = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (currentNode.children[index] == null)
				currentNode.children[index] = new TrieNode();

			currentNode = currentNode.children[index];
		}
		currentNode.isEndOfWord = true;
	}

	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode currentNode = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (currentNode.children[index] == null)
				return false;

			currentNode = currentNode.children[index];
		}
		return (currentNode.isEndOfWord);
	}

	static boolean isEmpty(TrieNode root) {
		for (int i = 0; i < NUM_CHARS; i++)
			if (root.children[i] != null)
				return false;
		return true;
	}

	static TrieNode delete(TrieNode root, String key, int depth) {
		// WRITE YOUR CODE HERE
		if (root == null)
			return null;
		if (depth == key.length()) {
			isDeleted = root.isEndOfWord;
			if (root.isEndOfWord)
				root.isEndOfWord = false;
			if (isEmpty(root)) {
				return null;
			}
			return root;
		}
		int index = key.charAt(depth) - 'a';

		if (root.children[index] == null)
			return null;

		root.children[index] = delete(root.children[index], key, depth + 1);
		if (isEmpty(root) && root.isEndOfWord == false) {
			return null;
		}
		return root;
	}

	static boolean isLeafNode(TrieNode root) {
		return root.isEndOfWord == true;
	}

	static void print(TrieNode root, char[] str, int level) {
		if (isLeafNode(root)) {
			for (int k = level; k < str.length; k++)
				str[k] = 0;
			System.out.println(str);
		}
		int i;
		for (i = 0; i < NUM_CHARS; i++) {
			if (root.children[i] != null) {
				str[level] = (char) (i + 'a');
				print(root.children[i], str, level + 1);
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String keys[] = sc.nextLine().split(" ");
		root = new TrieNode();
		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);
		char[] str = new char[50];
		while (true) {
			int opt = sc.nextInt();
			sc.nextLine();
			if (opt == 4) {
				// System.out.println("Content of Trie: ");
				print(root, str, 0);
			}
			if (opt == 1) {
				String s = sc.nextLine();
				insert(s);
				// System.out.println("Content of Trie: ");
				print(root, str, 0);
			} else if (opt == 2) {
				String word = sc.next();
				if (search(word) == true)
					System.out.println(word + " is present ");
				else
					System.out.println(word + " is not present");
			} else if (opt == 3) {
				String word = sc.next();
				if (delete(root, word, 0) != null & isDeleted == true) {
					System.out.println(word + " is deleted ");
				} else
					System.out.println(word + " is not present in Trie to be deleted");
				// System.out.println("Content of Trie after deletion: ");
				// print(root, str, 0);
			} else if (opt == 5) {
				break;
			}
		}
	}
}
