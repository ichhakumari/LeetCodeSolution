/**  Count the number of subarrays with given xor K */

import java.util.*;

public class Solution {

    public static int subarraysWithXorK(int []A, int B) {
        int n = A.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ A[i];

            //By formula: x = xr^k:
            int x = xr ^ B;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        int B = 6;
        int ans = subarraysWithXorK(A, B);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}



