# You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

# Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

# If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

class Solution:
  def maxProbability(
      self,
      n: int,
      edges: list[list[int]],
      succProb: list[float],
      start: int,
      end: int,
  ) -> float:
    graph = [[] for _ in range(n)]  # {a: [(b, probability_ab)]}
    maxHeap = [(-1.0, start)]   # (the probability to reach u, u)
    seen = [False] * n

    for i, ((u, v), prob) in enumerate(zip(edges, succProb)):
      graph[u].append((v, prob))
      graph[v].append((u, prob))

    while maxHeap:
      prob, u = heapq.heappop(maxHeap)
      prob *= -1
      if u == end:
        return prob
      if seen[u]:
        continue
      seen[u] = True
      for nextNode, edgeProb in graph[u]:
        if seen[nextNode]:
          continue
        heapq.heappush(maxHeap, (-prob * edgeProb, nextNode))

    return 0
