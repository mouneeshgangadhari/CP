import java.util.*;
class practice {
    public static boolean help(String S,String SC)
    {
        int i = 0, j = 0;
        while (i < S.length() && j < SC.length()) {
            int k=0;
            if (S.charAt(i) == SC.charAt(j)) {
                i++;
                j++;
            } else if (Character.isDigit(SC.charAt(j))) {
                while(j<SC.length() && Character.isDigit(SC.charAt(j)))
                {
                    k=k*10+Integer.parseInt(String.valueOf(SC.charAt(j)));
                    System.out.println(j);
                    j++;
                }
                System.out.println(k);
                i=i+k;
            }else{
                return false;
            }
            System.out.println(i+"  "+j);
        }
        System.out.println(i+"  "+j);
        return i == S.length() && j == SC.length();
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String s1=sc.next();
        System.out.println(help(str,s1));
    }
}