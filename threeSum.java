/** Q. 15  iven an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets. */

import java.util.*;

class Solution {

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      // remove duplicates:
      if (i != 0 && nums[i] == nums[i - 1]) continue;

      // moving 2 pointers:
      int j = i + 1;
      int k = nums.length - 1; // Use nums.length instead of n
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
          ans.add(temp);
          j++;
          k--;
          //skip the duplicates:
          while (j < k && nums[j] == nums[j - 1]) j++;
          while (j < k && nums[k] == nums[k + 1]) k--;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> ans = threeSum(nums);  // Pass only the array

    for (List<Integer> it : ans) {
      System.out.print("[");
      for (Integer i : it) {
        System.out.print(i + " ");
      }
      System.out.print("] ");
    }
    System.out.println();
  }
}



