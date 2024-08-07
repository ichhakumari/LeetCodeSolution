/**  Q. 1653 minimum deletions to make string balanced
You are given a string s consisting only of characters 'a' and 'b'​​​​.
You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
Return the minimum number of deletions needed to make s balanced. */

class Solution {
    public int minimumDeletions(String s) {
        int length = s.length(); 
        int minDeletions = 0; 
        int countB = 0; 

        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == 'b') {
                ++countB;
            } else {
                minDeletions = Math.min(minDeletions + 1, countB);
            }
        }
        return minDeletions;
    }
}
