/** Q 560 Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    A subarray is a contiguous non-empty sequence of elements within an array. */

import java.util.*;

class Solution {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>(); 
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map

        for (int i = 0; i < n; i++) {
            preSum += nums[i];

            int remove = preSum - k;

            // Cast the value retrieved from mpp to int before adding
            cnt += (int) mpp.getOrDefault(remove, 0);

            // Cast the value retrieved from mpp to int before adding 1
            mpp.put(preSum, (int) mpp.getOrDefault(preSum, 0) + 1);
        }

        // Add a return statement to return the final count
        return cnt;
    }

    // Implement the missing findAllSubarraysWithGivenSum method here
    // This method is not required for the logic of subarraySum
    // You can add it if needed for other functionalities

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int k = 6;
        int cnt = subarraySum(nums, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}

 
