/**Q217. Given an integer array nums, return true if any value appears at
least twice in the array, and return false if every element is distinct.*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer>numbers= new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(numbers.contains(nums[i]))
            return true;
            numbers.add(nums[i]);
        }
        return false;
    }
}
