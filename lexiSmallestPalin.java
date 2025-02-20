/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.
Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er
Sample Output-1:
----------------
redavader

Sample Input-2:
---------------
r#d#v#cer
Sample Output-2:
----------------
invalid

*/
import java.util.*;
class lexiSmallestPalin
{
    public static String help(String word){
        char[] chars = word.toCharArray();
        int n = chars.length;
        for (int i=0;i<n/2;i++) {
            if(chars[i]=='#'&&chars[n-i-1]!='#') {
                chars[i]=chars[n-i-1];
            } 
            else if(chars[i]!='#'&&chars[n-i-1]=='#') 
            {
                chars[n-i-1]=chars[i];
            } 
            else if(chars[i]!='#'&&chars[n-i-1]!='#') 
            {
                if(chars[i]!=chars[n-i-1]) {
                    return "invalid";
                }
            }
            else
            {
                chars[i]='a';
                chars[n-i-1]='a';
            }
        }
        
        if(n%2==1&&chars[n/2]=='#')
        {
            chars[n/2]='a';
        }
        
        return new String(chars);
        
    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(help(str));
    }
}


