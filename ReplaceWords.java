
/*In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

Example 1:
Input=3
cat
bat
rat
the cattle was rattled by the battery
Output=the cat was rat by the bat

Example 2:
Input=3
a 
b
c
aadsfasf absbs bbab cadsfafs
Output=a a b c

Constraints:
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.

Use the following Java code segement to solve above problem.
*/
import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // build a tri of the dictionary
        ReplaceWords t = processDict(dictionary);

        // while building a trie, if a shorter form of a root found,
        // update the entry with the shorter one.

        // process each word in the sentence (tokenized); if found in the tri
        // keep that form
        StringBuilder res = new StringBuilder();
        for (String word : sentence.split(" ")) {
            res.append(convert(word, t));
            res.append(' ');
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    String convert(String word, ReplaceWords t) {
        ReplaceWords parent = t;
        int idx = 0;
        for (char ch : word.toCharArray()) {
            parent = t;
            t = t.getSub(ch);
            if (t == null)
                break;
            idx++;
        }
        if (idx == 0)
            return word; // not found.
        if (!parent.terminal)
            return word; // partial match won't count
        return word.substring(0, idx);
    }

    // Tri: a
    // . b/ \n
    class ReplaceWords {
        public char ch;
        public boolean terminal = false;
        public Map<Character, ReplaceWords> nodes = new HashMap<>();

        public ReplaceWords(char ch) {
            this.ch = ch;
        }

        public void addSub(char ch, ReplaceWords sub) {
            nodes.put(ch, sub);
        }

        public ReplaceWords getSub(char ch) {
            return nodes.get(ch);
        }

        public boolean isEmpty() {
            return nodes.isEmpty();
        }

        public void clearSubs() {
            nodes.clear();
        }
    }

    ReplaceWords processDict(List<String> dict) {
        ReplaceWords tri = new ReplaceWords(' ');
        for (String word : dict)
            processWord(word, tri);
        return tri;
    }

    // '' - a - a|
    //
    void processWord(String word, ReplaceWords tri) {
        for (char ch : word.toCharArray()) {
            ReplaceWords sub = tri.getSub(ch);
            if (sub == null) {
                sub = new ReplaceWords(ch);
                tri.addSub(ch, sub);
            }
            tri = sub;
            if (tri.terminal) {
                break; // no need to add longer root
            }
        }
        // in case we found a smaller root
        tri.clearSubs();
        tri.terminal = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> dictionary = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            dictionary.add(word);
        }
        // sc.nextLine();
        String str = sc.nextLine();
        System.out.println(new Solution().replaceWords(dictionary, str));

    }
}