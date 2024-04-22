//Q.34 Find first and last postion of an element..
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //empty array
        if(nums.length==0){
            return new int[] {-1,-1};
        }

        int low=0;
        int high= nums.length-1;
        int result[]=new int[2];

        while(low<high){
            int mid= low+(high-low)/2;
            if(nums[mid]<target){
                low=mid+1;
            }

            else{
                high=mid;
            }
        }
        if (nums[low]!= target){
            return new int[] {-1,-1}; 
        }
        result[0]=low;
        high=nums.length;

        while(low<high){
            int mid = low +(high-low)/2;
             if(nums[mid]<=target){
                low=mid+1;
            }

            else{
                high=mid;
            }
        }
        result[1]=low-1;
        return result;
    }
}




