587. Delete and Earn
Medium
Given an array of integers, each time you could delete one integer, say nums[i] and add it to you total score, but then you have to delete all integers that equals to nums[i] + 1 or nums[i] - 1 and can NOT add them to total score. Return the maximum score you could add up to using the given integer array.



Example 1:

Input: nums = [1,2,3]

Output: 4

Explanation:

Delete 1 and add it to total score. Total score = 0 + 1 = 1. Consequently 2 is deleted and can NOT be added to total score.
Delete 3 and add it to total score. Total score = 1 + 3 = 4.
Example 2:

Input: nums = [2,3,4,4]

Output: 10

Explanation:

Delete 2 and add it to total score. Total score = 0 + 2 = 2. Consequently 3 is deleted and can NOT be added to total score.
Delete 4 and add it to total score. Total score = 2 + 4 = 6.
Delete 4 and add it to total score. Total score = 6 + 4 = 10.
Assumptions:

Originally your total score is 0.
The length of given array is no more than 20000.
Each number in the given integer array is in range of [1, 10000].
