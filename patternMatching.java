/*
//https://leetcode.com/problems/camelcase-matching/description/
Mr. Balu is tasked with developing a pattern matching algorithm to determine if given strings adhere to a specific pattern. He will be Given an array of strings queries and a string pattern, and he need to return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
Can you develop a program for this task, Use Trie Approach to solve this problem.

A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.

Input format : comma seperated strings
			   String
output format: list consists of true or false

Example 1:

Input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FB
Output= [true,false,true,true,false]
Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".

Example 2=
Input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FoBa
Output= [true,false,true,false,false]
Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

Example 3:
Input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FoBaT
Output=[false,true,false,false,false]
Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 
Constraints:
1 <= pattern.length, queries.length <= 100
1 <= queries[i].length <= 100
queries[i] and pattern consist of English letters.
*/
import java.util.*;
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode()
    {
        children = new TrieNode[58];
    }
}
class Solution {
    TrieNode root;
    public Solution() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray())
        {
            if(temp.children[ch-'A']==null)
            {
                temp.children[ch-'A'] = new TrieNode();
            }
            temp = temp.children[ch-'A'];
        }
        temp.isEnd = true;
    }
    boolean fun(String s, int n)
    {
        TrieNode temp = root;
        int c = 0;
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(temp.children[ch-'A']!=null)
            {
                c++;
                temp = temp.children[ch-'A'];
            }
            else if(ch>='A' && ch<='Z') return false;
        }
        return c == n;
    }
 public List<Boolean> camelMatch(String[] queries, String pattern) {
        insert(pattern);
        List<Boolean> ans = new ArrayList<>();
        for(String s : queries)
        {
            boolean f = fun(s, pattern.length());
            ans.add(f);
        }
        return ans;
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String[] words = sc.nextLine().split(",");
		String key = sc.nextLine();
		System.out.println(new Solution().camelMatch(words,key));

	}
}
/*
test cases
case =1
input=GenerativeAi,GenAi,GeneraTor,GenrationX
GA
output=[true, true, false, false]
case =2
input=generativeai,genai,generator,genrationx
ga
output=[true, true, true, true]
case=3
input=generativeai,genai,generator,genrationx
gb
output=[false, false, false, false]
case=4
input=Kmit,Kmec,Kmce,Kmes
K
output=[true, true, true, true]
case =5
input=That,Thirst,Thought,Throat
Tt
output=[true, true, true, true]
case =6
input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FB
Output= [true,false,true,true,false]
case=7
input=FootBall,FootBag,FootBase,FootBean
FoB
output=[true, true, true, true]
case=8
input=FriendRequest,FrenchfRies,FrontRear,FrontieR
FrR
output=[true, true, true, true]
*/
