628. Is the Last Character One-bit or Not
Easy
Suppose we present three special characters using binary number 0, 10, 11.

Given an array of integers containing only 1s and 0s to present a string that made up with the three special characters.

Return the whether the last character of the string represented by the given array is a one-bit character or not.

Assumptions:

1. The given array is not null and its length is always >= 1.

2. The last number of the given array is always 0.

Example 1:

Input:[1,1,0,0]

Output: True

Explanation: the given string is (11, 0, 0) then the last character can be one-bit

Example 2:

Input: [1,1,1,0]

Output: False

Explanation: The given string is (11, 10) then the last character cannot be one-bit to make it a valid string.
