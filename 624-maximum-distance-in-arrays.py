# You are given m arrays, where each array is sorted in ascending order.

# You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.

# Return the maximum distance.

 
class Solution:
  def maxDistance(self, arrays: list[list[int]]) -> int:
    ans = 0
    mn = 10000
    mx = -10000

    for A in arrays:
      ans = max(ans, A[-1] - mn, mx - A[0])
      mn = min(mn, A[0])
      mx = max(mx, A[-1])

    return ans
