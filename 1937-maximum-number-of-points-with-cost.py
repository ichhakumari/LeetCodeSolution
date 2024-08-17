# You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

# To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

# However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

# Return the maximum number of points you can achieve. 

class Solution:
  def maxPoints(self, points: list[list[int]]) -> int:
    n = len(points[0])
    # dp[j] := the maximum number of points you can have if points[i][j] is the
   
    dp = [0] * n

    for row in points:
      leftToRight = [0] * n
      runningMax = 0
      for j in range(n):
        runningMax = max(runningMax - 1, dp[j])
        leftToRight[j] = runningMax

      rightToLeft = [0] * n
      runningMax = 0
      for j in range(n - 1, - 1, -1):
        runningMax = max(runningMax - 1, dp[j])
        rightToLeft[j] = runningMax

      for j in range(n):
        dp[j] = max(leftToRight[j], rightToLeft[j]) + row[j]

    return max(dp)

