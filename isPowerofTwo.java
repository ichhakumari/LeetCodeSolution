// Q.231 Power of Two : Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.

class Solution {
    public boolean isPowerOfTwo(int n) {
        long i=1;

        while(i<n){
            i=i*2;
        }

        // if(i==n){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        return i==n? true:false;
    }
}
