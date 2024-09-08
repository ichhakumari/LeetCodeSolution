# Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

# The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

# The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

# Return an array of the k parts

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
  def splitListToParts(self, root: ListNode, k: int) -> list[ListNode]:
    ans = [[] for _ in range(k)]
    length = 0
    curr = root
    while curr:
      length += 1
      curr = curr.next
    subLength = length // k
    remainder = length % k

    prev = None
    head = root

    for i in range(k):
      ans[i] = head
      for j in range(subLength + (1 if remainder > 0 else 0)):
        prev = head
        head = head.next
      if prev:
        prev.next = None
      remainder -= 1

    return ans
        
