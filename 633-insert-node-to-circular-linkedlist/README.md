Given an integer and a ListNode in a sorted circular LinkedList, insert a new node to this LinkedList.

If the given ListNode is null, then you should create a new ListNode with the given integer and link it to itself, then return the new node. Otherwise, return the given ListNode.

If there are multiple places that you could insert the new node, then you can insert it to any valid position.

Although the LinkedList is sorted, the given node could be any node in it, not necessarily the smallest one or largest one.

Example 1:

Input: head = 4 -> 5 -> 1 -> 2 -> (4), newVal = 0

Output: 4 -> 5 -> 0 -> 1 -> 2 -> (4)

Example 2:

Input: head = 4 -> 5 -> 1 -> 2 -> (4), newVal = 6

Output: 4 -> 5 -> 6 -> 1 -> 2 -> (4)

Example 3:

Input: head = 4 -> 5 -> 1 -> 2 -> (4), newVal = 3

Output: 4 -> 5 -> 1 -> 2 -> 3 -> (4)

Example 4:

Input: head = null, newVal = 3

Output: 3 -> (3)
