package Streams;

/*
Write a java code to partition the Numbers into Prime and Non-Prime

Input:
======
2 3 4 5 6 7 8 9 10

Output:
=======
Prime numbers: [2, 3, 5, 7]
Non-prime numbers: [4, 6, 8, 9, 10]


*/

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Streams3 {
    public static boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        String[] inputs = scanner.nextLine().split(" ");
        for (String input : inputs) {
            numbers.add(Integer.parseInt(input));
        }

        //Complete your code here
        Map<Boolean,List<Integer>> num=numbers.stream().collect(Collectors.partitioningBy(Solution::isPrime));
        System.out.println("Prime numbers: "+num.get(true));
        System.out.println("Non-prime numbers:"+num.get(false));
    }

}
