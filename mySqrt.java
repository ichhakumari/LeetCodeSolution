/** Q69  Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator. */

public class Solution {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        // Handle corner cases for very large numbers
        if (x > 46340 * 46340) {
            return 46340; 
        }

        long low = 1;
        long high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int) mid; 
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Rounding down using long arithmetic
        return (int) high;
    }

    public static void main(String[] args) {
        int num = 2147483647; 
        int sqrt = mySqrt(num);
        System.out.println("The square root of " + num + " (rounded down) is: " + sqrt);
    }
}
