/** 1508. Range Sum of Sorted Subarray Sums 
The given problem revolves around finding the sum of a specific subset of a sorted array that contains sums of all non-empty continuous subarrays of the given array nums. The problem requires three inputs:

nums - an array of n positive integers.
left - the starting index from which to sum (one-indexed).
right - the ending index up to which to sum (one-indexed).
Our objective is to compute the sum of all non-empty continuous subarrays, sort these sums, and then calculate the sum of the elements from the left to right indices in the sorted array. The final answer should be returned modulo 10^9 + 7 to handle very large numbers which could cause integer overflow situations.
  */

import java.util.Arrays; 

class Solution {
  
    public int rangeSum(int[] nums, int n, int left, int right) {
        int totalSubarrays = n * (n + 1) / 2;
        
        int[] subarraySums = new int[totalSubarrays];
      
        int index = 0; 
        for (int i = 0; i < n; ++i) {
            int currentSum = 0; 
            for (int j = i; j < n; ++j) {
                currentSum += nums[j];
                subarraySums[index++] = currentSum; 
            }
        }
      
        // Sort the array of subarray sums
        Arrays.sort(subarraySums);
      
        int result = 0; 
        final int mod = (int) 1e9 + 7; 

        for (int i = left - 1; i < right; ++i) {
            result = (result + subarraySums[i]) % mod;
        }
      
        return result; 
    }
}
