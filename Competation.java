/*
 *  An English competition is taking place in a school. 
One problem is given in the following manner 
There are words formed with lower case alphabets, participants need to 
find the count of characters which are repeatedly appeared in all words. 
If no such characters are there, then return 0.

Note: give solution using bit manipulation only

input format: comma separated strings
output format: an integer

Example
input = abc,abc,bc
output=2
The characters 'b' and 'c' appear in each word, so there output is 2 .

Input Format: comma separated strings.
output format: an integer 		

SAMPLE INPUT  
       
abcdde,baccd,eeabg

SAMPLE OUTPUT
2
Explanation

Only 'a' and 'b' occur in every word.


Constraints
Each word consists of only lower-case letters ('a'-'z').

You may use following Java code segment to solve this problem.

import java.util.*;
 class Solution 
 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        int result = Competition(words);
        System.out.println(result);
    }

    static int Competition(String[] arr) 
    {
        //WRITE YOUR CODE HERE
    }
}

 */
public class Competation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        int result = Competition(words);
        System.out.println(result);
    }

    static int Competition(String[] arr) {
        int bitmask = (1 << 26) - 1; // Initialize bitmask with all bits set

        for (String word : arr) {
            int wordMask = 0;
            for (char c : word.toCharArray()) {
                wordMask |= (1 << (c - 'a')); // Set the corresponding bit for each character in the word
            }
            bitmask &= wordMask; // Update bitmask by AND operation with the word's bitmask
        }

        // Count the number of bits set in the bitmask
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if ((bitmask & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
