/*
Input a String s.
Partition the given string such that every substring of the partition is a 
palindrome. 
Return all possible palindrome partitioning of s.

 
Example 1:
Input: s = aab
Output: [[a,a,b],[aa,b]]

Example 2:
Input: s = a
Output: [[a]]
 

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
*/
import java.util.*;
public class StringPartitioning 
{
    public List<List<String>> partition(String s) 
	{
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) 
	{
        // If we've reached the end of the string, add the current partition to the result list
        if (start == s.length()) 
		{
            result.add(new ArrayList<>(path));
            return;
        }
        // Explore all possible partitions
        for (int end = start + 1; end <= s.length(); end++) 
		{
            // If the current substring is a palindrome, add it to the current path
            if (isPalindrome(s, start, end - 1)) 
			{
                path.add(s.substring(start, end));
                // Recur to find other partitions
                backtrack(s, end, path, result);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) 
	{
        // Check if the substring s[left:right+1] is a palindrome
        while (left < right) 
		{
            if (s.charAt(left++) != s.charAt(right--)) 
                return false;
        }
        return true;
    }
	public static void main(String args[] )
	{	
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(new StringPartitioning().partition(s));
	}

}


/*
Test Cases:
case=1
input=aab
output=[[a, a, b], [aa, b]]

case=2
input=aaaaa
output=[[a, a, a, a, a], [a, a, a, aa], [a, a, aa, a], [a, a, aaa], [a, aa, a, a], [a, aa, aa], [a, aaa, a], [a, aaaa], [aa, a, a, a], [aa, a, aa], [aa, aa, a], [aa, aaa], [aaa, a, a], [aaa, aa], [aaaa, a], [aaaaa]]

case=3
input=aaabbbaaa
output=[[a, a, a, b, b, b, a, a, a], [a, a, a, b, b, b, a, aa], [a, a, a, b, b, b, aa, a], [a, a, a, b, b, b, aaa], [a, a, a, b, bb, a, a, a], [a, a, a, b, bb, a, aa], [a, a, a, b, bb, aa, a], [a, a, a, b, bb, aaa], [a, a, a, bb, b, a, a, a], [a, a, a, bb, b, a, aa], [a, a, a, bb, b, aa, a], [a, a, a, bb, b, aaa], [a, a, a, bbb, a, a, a], [a, a, a, bbb, a, aa], [a, a, a, bbb, aa, a], [a, a, a, bbb, aaa], [a, a, abbba, a, a], [a, a, abbba, aa], [a, aa, b, b, b, a, a, a], [a, aa, b, b, b, a, aa], [a, aa, b, b, b, aa, a], [a, aa, b, b, b, aaa], [a, aa, b, bb, a, a, a], [a, aa, b, bb, a, aa], [a, aa, b, bb, aa, a], [a, aa, b, bb, aaa], [a, aa, bb, b, a, a, a], [a, aa, bb, b, a, aa], [a, aa, bb, b, aa, a], [a, aa, bb, b, aaa], [a, aa, bbb, a, a, a], [a, aa, bbb, a, aa], [a, aa, bbb, aa, a], [a, aa, bbb, aaa], [a, aabbbaa, a], [aa, a, b, b, b, a, a, a], [aa, a, b, b, b, a, aa], [aa, a, b, b, b, aa, a], [aa, a, b, b, b, aaa], [aa, a, b, bb, a, a, a], [aa, a, b, bb, a, aa], [aa, a, b, bb, aa, a], [aa, a, b, bb, aaa], [aa, a, bb, b, a, a, a], [aa, a, bb, b, a, aa], [aa, a, bb, b, aa, a], [aa, a, bb, b, aaa], [aa, a, bbb, a, a, a], [aa, a, bbb, a, aa], [aa, a, bbb, aa, a], [aa, a, bbb, aaa], [aa, abbba, a, a], [aa, abbba, aa], [aaa, b, b, b, a, a, a], [aaa, b, b, b, a, aa], [aaa, b, b, b, aa, a], [aaa, b, b, b, aaa], [aaa, b, bb, a, a, a], [aaa, b, bb, a, aa], [aaa, b, bb, aa, a], [aaa, b, bb, aaa], [aaa, bb, b, a, a, a], [aaa, bb, b, a, aa], [aaa, bb, b, aa, a], [aaa, bb, b, aaa], [aaa, bbb, a, a, a], [aaa, bbb, a, aa], [aaa, bbb, aa, a], [aaa, bbb, aaa], [aaabbbaaa]]

case=4
input=ababab
output=[[a, b, a, b, a, b], [a, b, a, bab], [a, b, aba, b], [a, bab, a, b], [a, babab], [aba, b, a, b], [aba, bab], [ababa, b]]

case=5
input=daddy
output=[[d, a, d, d, y], [d, a, dd, y], [dad, d, y]]

case=6
input=probably
output=[[p, r, o, b, a, b, l, y], [p, r, o, bab, l, y]]

case=7
input=a
output=[[a]]

case=8
input=madam
output=[[m, a, d, a, m], [m, ada, m], [madam]]

case=9
input=aabccbaa
output=[[a, a, b, c, c, b, a, a], [a, a, b, c, c, b, aa], [a, a, b, cc, b, a, a], [a, a, b, cc, b, aa], [a, a, bccb, a, a], [a, a, bccb, aa], [a, abccba, a], [aa, b, c, c, b, a, a], [aa, b, c, c, b, aa], [aa, b, cc, b, a, a], [aa, b, cc, b, aa], [aa, bccb, a, a], [aa, bccb, aa], [aabccbaa]]

case=10
input=palindrome
output=[[p, a, l, i, n, d, r, o, m, e]]
*/