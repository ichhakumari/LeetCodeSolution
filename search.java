/**704 Binary Search  
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.*/
import java.util.*;

class Solution {

    public static int search(int[] nums, int target) {
        int n = nums.length; // size of the array
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        int ind = search(a, target);

        if (ind == -1) {
            System.out.println("The target is not present.");
        } else {
            System.out.println("The target is at index: " + ind);
        }
    }
}
