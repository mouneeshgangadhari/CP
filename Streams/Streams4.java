package Streams;

/*
Write a java code to flatten the Nested Lists using FlatMap function of Streams.

Input:
======
2
apple banana
orange peach

Output:
=======
Flattened List: [apple, banana, orange, peach]

*/

import java.util.*;
import java.util.stream.*;

public class Streams4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> nestedList = new ArrayList<>();

        int numLists = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numLists; i++) {
            String[] items = scanner.nextLine().split(" ");
            nestedList.add(Arrays.asList(items));
        }

        //Implement your logic here
        List<String> res=new ArrayList<>();
        res=nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Flattened List: "+res);
    }
}
