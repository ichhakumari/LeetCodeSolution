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
