/*


You are designing a module for a Large Language Model (LLM) that takes two words: source and target, along with a set of supporting words. The goal of this module is to determine if it is feasible of morphing  the source into the target by sequentially changing one letter at a time, with each intermediate word being a valid word from the set of supporting words.

If the morphing is possible, the module should print the number of words in the shortest sequence (including both source and target) required to achieve this morphing. If it is not possible, the module should print 0.

Note :Every adjacent pair of words differs by a single letter.
      Source word needn't in present in the supporting words list,but target word must be in the list.

input format : two words
			   list of comma separated words
output format : an integer
 
Example 1:
Input= hit
cog
hot,dot,dog,lot,log,cog
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input=hit
cog
hot,dot,dog,lot,log
Output: 0
Explanation: The targetWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= source.length <= 10
target.length == source.length
1 <= wordList.length <= 5000
wordList[i].length == source.length
source_word, target_Word, and wordList[i] consist of lowercase English letters.
sourceWord != targetWord
All the words in wordList are unique.

*/

import java.util.*;
class Solution {
    public int morphing(String sourceword, String targetword, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        if (!wordSet.contains(targetword)) {
            return 0;  // If targetword is not in wordList, no possible transformation
        }
        return bfs(sourceword, targetword, wordSet);
    }
    private int bfs(String sourceword, String targetword, Set<String> wordSet) {
        Queue<String> queue = new LinkedList<>();
        queue.add(sourceword);
        int moves = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;  // Increment move count for each level of BFS
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] currentWordArr = currentWord.toCharArray();
                for (int j = 0; j < currentWordArr.length; j++) {
                    char originalChar = currentWordArr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue;
                        currentWordArr[j] = ch;
                        String newWord = new String(currentWordArr);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(targetword)) {
                                return moves;  // If newWord is the targetword, return the move count
                            }
                            wordSet.remove(newWord);  // Remove newWord from the set to prevent revisits
                            queue.offer(newWord);  // Enqueue the newWord for further exploration
                        }
                    }
                    currentWordArr[j] = originalChar;  // Restore the original character before the next iteration
                }
            }
        }
        return 0;  // Return 0 if no transformation sequence is found
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the begin word:");
        String sourceword = sc.nextLine();
  //      System.out.println("Enter the end word:");
        String targetword = sc.nextLine();
    //    System.out.println("Enter the word list (comma separated):");
        String[] wordList = sc.nextLine().split(",");
        Solution solution = new Solution();
        int result = solution.morphing(sourceword, targetword, wordList);
        System.out.println(result);  // Output the result
    }
}
/*
case =1
input =a
b
a,c,d,b
output=2
case =2
input=abc
xyz
xbc,xyc,xyz
output=4
case =3
input=lead
gold
load,goad,gold
output=4
case =4
input=hello
world
hallo,hollo,holld,wolld,world
output=5
case =5
input=hit
cog
hot,dot,dog,lot,log
Output=0
*/