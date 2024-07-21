/*



Mr Ajay Sharma is working with words.
He found that few words in the langugage have same meaning.
Such words are given as a list of pairs as mappedpairs[],
where mappedpairs[i] = [word1, word2] indicates that word1 and word2 are 
the words with same meaning.

He is given phrase, and he wants to apply all the mappedpairs[] on the phrase.

Your task is to help Mr.Ajay Sharma to find and return all possible 
Mapped Phrases generated after applying all the mapped words,
and print them in lexicographical order.


Input Format:
-------------
Line-1: An integer N, number of mapped pairs.
Next N lines: Two space separated words, mappedpair[].
Last Line: A line of words, the phrase.

Output Format:
--------------
Print the list of mapped phrases in sorted order.


Sample Input-1:
---------------
3
hi hello
sweet sugar
candy chocolate
hi sam! ram has a sugar candy

Sample output-1:
---------------
[hello sam! ram has a sugar candy, hello sam! ram has a sugar chocolate, hello sam! ram has a sweet candy, hello sam! ram has a sweet chocolate, hi sam! ram has a sugar candy, hi sam! ram has a sugar chocolate, hi sam! ram has a sweet candy, hi sam! ram has a sweet chocolate]


Sample Input-2:
---------------
2
hi hey
hey hello
hi how are you

Sample Output-2:
----------------
[hello how are you, hey how are you, hi how are you]
*/
import java.util.*;
class Solution {
  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    Set<String> ans = new TreeSet<>();
    Map<String, List<String>> graph = new HashMap<>();
    Queue<String> q = new ArrayDeque<>(Arrays.asList(text));

    for (List<String> synonym : synonyms) {
      final String s = synonym.get(0);
      final String t = synonym.get(1);
      graph.putIfAbsent(s, new ArrayList<>());
      graph.putIfAbsent(t, new ArrayList<>());
      graph.get(s).add(t);
      graph.get(t).add(s);
    }

    while (!q.isEmpty()) {
      final String u = q.poll();
      ans.add(u);
      String[] words = u.split("\\s");
      for (int i = 0; i < words.length; ++i)
        for (final String synonym : graph.getOrDefault(words[i], new ArrayList<>())) {
          // Replace words[i] with its synonym.
          words[i] = synonym;
          final String newText = String.join(" ", words);
          if (!ans.contains(newText))
            q.offer(newText);
        }
    }

    return new ArrayList<>(ans);
  }
  public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	sc.nextLine();
	List<List<String>> synonyms = new ArrayList<>();
	for (int i=0;i<n ;i++ )
	{
		String pair = sc.nextLine();
        String[] words = pair.split("\\s+");
		List<String> synonymPair = new ArrayList<>(Arrays.asList(words));
        synonyms.add(synonymPair);
	}
	String str1 = sc.nextLine();
	System.out.println(new Solution().generateSentences(synonyms,str1));

  }
}





/*


=== testcases ===
case =1
input =3
hi hello
sweet sugar
candy chocolate
hi sam! he has sugar candy
output =[hello sam! he has sugar candy, hello sam! he has sugar chocolate, hello sam! he has sweet candy, hello sam! he has sweet chocolate, hi sam! he has sugar candy, hi sam! he has sugar chocolate, hi sam! he has sweet candy, hi sam! he has sweet chocolate]

case =2
input =2
hi hey
hey hello
hi how are you
output =[hello how are you, hey how are you, hi how are you]

case =3
input =3
happy joy
sad sorrow
joy cheerful
i am happy today but was sad yesterday
output =[i am cheerful today but was sad yesterday, i am cheerful today but was sorrow yesterday, i am happy today but was sad yesterday, i am happy today but was sorrow yesterday, i am joy today but was sad yesterday, i am joy today but was sorrow yesterday]

case =4
input =4
better good
arrive come
late behind
all whole
better to arrive late than not to come at all
output =[better to arrive behind than not to arrive at all, better to arrive behind than not to arrive at whole, better to arrive behind than not to come at all, better to arrive behind than not to come at whole, better to arrive late than not to arrive at all, better to arrive late than not to arrive at whole, better to arrive late than not to come at all, better to arrive late than not to come at whole, better to come behind than not to arrive at all, better to come behind than not to arrive at whole, better to come behind than not to come at all, better to come behind than not to come at whole, better to come late than not to arrive at all, better to come late than not to arrive at whole, better to come late than not to come at all, better to come late than not to come at whole, good to arrive behind than not to arrive at all, good to arrive behind than not to arrive at whole, good to arrive behind than not to come at all, good to arrive behind than not to come at whole, good to arrive late than not to arrive at all, good to arrive late than not to arrive at whole, good to arrive late than not to come at all, good to arrive late than not to come at whole, good to come behind than not to arrive at all, good to come behind than not to arrive at whole, good to come behind than not to come at all, good to come behind than not to come at whole, good to come late than not to arrive at all, good to come late than not to arrive at whole, good to come late than not to come at all, good to come late than not to come at whole]

case =5
input =4
better good
good nice
bad worst
first start
better to arrive late than not to come at all a good thing that seemed bad at first
output =[better to arrive late than not to come at all a better thing that seemed bad at first, better to arrive late than not to come at all a better thing that seemed bad at start, better to arrive late than not to come at all a better thing that seemed worst at first, better to arrive late than not to come at all a better thing that seemed worst at start, better to arrive late than not to come at all a good thing that seemed bad at first, better to arrive late than not to come at all a good thing that seemed bad at start, better to arrive late than not to come at all a good thing that seemed worst at first, better to arrive late than not to come at all a good thing that seemed worst at start, better to arrive late than not to come at all a nice thing that seemed bad at first, better to arrive late than not to come at all a nice thing that seemed bad at start, better to arrive late than not to come at all a nice thing that seemed worst at first, better to arrive late than not to come at all a nice thing that seemed worst at start, good to arrive late than not to come at all a better thing that seemed bad at first, good to arrive late than not to come at all a better thing that seemed bad at start, good to arrive late than not to come at all a better thing that seemed worst at first, good to arrive late than not to come at all a better thing that seemed worst at start, good to arrive late than not to come at all a good thing that seemed bad at first, good to arrive late than not to come at all a good thing that seemed bad at start, good to arrive late than not to come at all a good thing that seemed worst at first, good to arrive late than not to come at all a good thing that seemed worst at start, good to arrive late than not to come at all a nice thing that seemed bad at first, good to arrive late than not to come at all a nice thing that seemed bad at start, good to arrive late than not to come at all a nice thing that seemed worst at first, good to arrive late than not to come at all a nice thing that seemed worst at start, nice to arrive late than not to come at all a better thing that seemed bad at first, nice to arrive late than not to come at all a better thing that seemed bad at start, nice to arrive late than not to come at all a better thing that seemed worst at first, nice to arrive late than not to come at all a better thing that seemed worst at start, nice to arrive late than not to come at all a good thing that seemed bad at first, nice to arrive late than not to come at all a good thing that seemed bad at start, nice to arrive late than not to come at all a good thing that seemed worst at first, nice to arrive late than not to come at all a good thing that seemed worst at start, nice to arrive late than not to come at all a nice thing that seemed bad at first, nice to arrive late than not to come at all a nice thing that seemed bad at start, nice to arrive late than not to come at all a nice thing that seemed worst at first, nice to arrive late than not to come at all a nice thing that seemed worst at start]

case =6
input =4
good nice
bad worst
first start
seemed looked
a good thing that seemed bad at first
output =[a good thing that looked bad at first, a good thing that looked bad at start, a good thing that looked worst at first, a good thing that looked worst at start, a good thing that seemed bad at first, a good thing that seemed bad at start, a good thing that seemed worst at first, a good thing that seemed worst at start, a nice thing that looked bad at first, a nice thing that looked bad at start, a nice thing that looked worst at first, a nice thing that looked worst at start, a nice thing that seemed bad at first, a nice thing that seemed bad at start, a nice thing that seemed worst at first, a nice thing that seemed worst at start]

*/

