//   Q.205 Isomorphic strings


class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] mapS = new int[128]; // Assuming ASCII characters
    int[] mapT = new int[128];

    for (int i = 0; i < s.length(); i++) {
      char charS = s.charAt(i);
      char charT = t.charAt(i);

      // Check if characters map to different characters in each string
      if (mapS[charS] != mapT[charT]) {
        return false;
      }

      // Update mappings if characters haven't been seen before
      if (mapS[charS] == 0 && mapT[charT] == 0) {
        mapS[charS] = i + 1;
        mapT[charT] = i + 1;
      }
    }

    return true;
  }
}
