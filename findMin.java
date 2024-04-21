/**Q.153 Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
  For example, the array nums = [0,1,2,4,5,6,7] might become*/

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high= nums.length -1;

        while(low<high){
           int mid= low+(high-low)/2;

            if(nums[mid] > nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return nums[high];
    }
}
