/*
Mr. Vasu is solving a puzzle. In this puzzle, he is given a string and an 
abbreviation string. He needs to determine whether it is possible to form the 
given string using the abbreviation string.
An abbreviation string is a compressed representation of a string, where a number 
in the abbreviation represents the count of consecutive characters it replaces. 

For example, 'word' can be abbreviated as 'w2d', where '2' represents 
two characters 'or' being replaced. With your programming skills help vasu 
to solve this puzzle.

input format: two strings 
output format : true or false

sample test cases:
case =1
input=apple
a2le
output=true
case =2
input= intelligent
int3ligent
output=false

*/

import java.util.*;
class validword
{
    public boolean isvalid(String s1,String s2)
    {
        int i=0,j=0;
        int n1 = s1.length(),n2 = s2.length();
        while(i<n1 && j<n2)
        {
            if(Character.isLetter(s1.charAt(i)) && Character.isLetter(s2.charAt(j))){
                if(s1.charAt(i)!=s2.charAt(j)) return false;
                i++;
                j++;
            }
            else
            {
                int t=0;
                while(j<n2)
                {
                    if(Character.isDigit(s2.charAt(j))){
                        t = t*10+Integer.parseInt(String.valueOf(s2.charAt(j)));
                        j++;
                    }
                    else break;
                    
                }
                i += t;
            }
            System.out.println(i+" "+j);
        }
        return i==n1 && j==n2;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(new validword().isvalid(s1,s2));
    }
}