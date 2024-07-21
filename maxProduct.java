/*
 * Sukumar is a mathematics teacher.
Sukumar is always intersted to create logical problems.
He has given a problem to the students to solve it.
Students are given sentence with set of words, students has to find two words
W1 and W2, such that there should be no common letters between W1 and W2, 
and return the product of W1.length and W2.length.
If there are no such words in the sentence return 0.

Your task is to solve the problem given by Sukumar and help the students.

Input Format:
-------------
Space separated strings, the sentence with set of words[].

Output Format:
--------------
Print an integer, maximum product of two max length words.


Sample Input-1:
---------------
there is an wondeful event going to happen in the school

Sample Output-1:
----------------
30

Explanation: 
------------
The two words will be "there", "school".
or "going", "happen"..etc


Sample Input-2:
---------------
elegant jewels are made here

Sample Output-2:
----------------
0

Explanation: 
------------
All words have atleast one letter in common.

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.


 */
public class maxProduct {
    public class MaxProductOfWords {
        public static void main(String[] args) {
            String[] words = args[0].split(" ");
            System.out.println(maxProduct(words));
        }

        public static int maxProduct(String[] words) {
            int maxProduct = 0;
            int[] masks = new int[words.length];

            for (int i = 0; i < words.length; i++) {
                for (char c : words[i].toCharArray()) {
                    masks[i] |= 1 << (c - 'a');
                }
            }

            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((masks[i] & masks[j]) == 0) {
                        maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                    }
                }
            }

            return maxProduct;
        }
    }
}
