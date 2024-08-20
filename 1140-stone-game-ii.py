# Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 
# Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
# On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
# The game continues until all the stones have been taken.
# Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        @cache
        def dfs(i, m, total):
            # used to compare the max number of stones
            res = 0
            # used to record how many stones we've taken
            taken = 0
            # i is the starting position
            # we can take at most i + 2 * m piles
            # however, it may exceed the size of piles 
            # hence use min to get the max limit
            for j in range(i, min(i + 2 * m, n)):
                # take this pile of stones
                taken += piles[j]
                # move to the next position
                # with the new M = max(M, X)
                # where X is how many piles we've taken so far which is j - i + 1
                res = max(res, total - dfs(j + 1, max(m, j - i + 1), total - taken))
            return res
        return dfs(0, 1, sum(piles))
