// Q.231 Power of Two

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
