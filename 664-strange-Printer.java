// There is a strange printer with the following two special properties:

// The printer can only print a sequence of the same character each time.
// At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
// Given a string s, return the minimum number of turns the printer needed to print it.

class Solution {
    private int[][] dp;
    public int strangePrinter(String s) {
        int len = s.length();
        dp = new int[len + 1][len + 1];
        return turn(s, 1, len);
    }
    private int turn(String s, int i, int j){
        if(i > j) return 0; //empty string.
        else if(dp[i][j] > 0) return dp[i][j]; //Cached
        else{
            //Give the fall back.
            dp[i][j] = turn(s, i, j - 1) + 1;
            for(int k = i; k < j; k++){
                if(s.charAt(j - 1) == s.charAt(k - 1))
                    dp[i][j] = Math.min(turn(s, i, k) + turn(s, k + 1, j - 1), dp[i][j]);
            }
            return dp[i][j];
        }
    }
}
