public class Solution {

    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                if (currentDepth == 0) {
                    // Mismatched closing parenthesis, invalid string
                    return -1;
                }
                currentDepth--;
            }
        }

        // Check if all opening parentheses are closed
        if (currentDepth > 0) {
            return -1;
        }

        return maxDepth;
    }
}
