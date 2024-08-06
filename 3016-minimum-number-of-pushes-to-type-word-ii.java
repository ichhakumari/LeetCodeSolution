/** 3016-minimum-number-of-pushes-to-type-word-ii.java

You are given a string word containing lowercase English letters.
Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example,
the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter
must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
  */

class Solution {
  public int minimumPushes(String word) {
    int ans = 0;
    int[] count = new int[26];

    for (final char c : word.toCharArray())
      ++count[c - 'a'];

    Arrays.sort(count);

    for (int i = 0; i < 26; ++i)
      ans += count[26 - i - 1] * (i / 8 + 1);

    return ans;
  }
}
