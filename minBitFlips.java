/**Q 2220 MINIMUM BITS FLIPS TO CONVERT A NUMBER
*/
class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cnt = 0;
        
        while(ans != 0){
            ans = ans & (ans -1);
            cnt = cnt +1;
        }
        
        return cnt;
    }
  }