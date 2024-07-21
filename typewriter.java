/*
Aruna as a data entry operator, typing a document in her laptop. Suddently her 
system got hacked and whatever she types as words are displaying in reverse and 
with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.

*/

import java.util.*;
class typewriter
{
    public static String help(String str){
        Stack<Character> s1=new Stack<>();
        for (char c:str.toCharArray()) {
            if(c!=')') 
            {
                s1.push(c);
            } 
            else{
                StringBuilder sb=new StringBuilder();
                while(!s1.isEmpty() && s1.peek() != '(') {
                    sb.append(s1.pop());
                }
                if(!s1.isEmpty()) {
                    s1.pop();
                }
                for(char ch:sb.toString().toCharArray()) {
                    s1.push(ch);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!s1.isEmpty()) {
            result.append(s1.pop());
        }
        return result.reverse().toString();

    }
    public static void main(String v[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(help(str) );
        
    }
}
