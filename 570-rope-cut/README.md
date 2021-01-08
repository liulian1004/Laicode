570. Rope Cut
Easy
There are N ropes with the same length horizontally arranged in a row. Each rope was radomly cut into several segments. Suppose a vertical line from the top to the bottom. The line doesn't cross a rope segment if it goes through an edge of a segment of a rope. Find a vertical line that cross the least number of rope segments. Return the number of rope segments that the line crossed.

The vertical line shall NOT at the left-most or right-most edge of the ropes since in these two cases this line does not across any rope segments.

The rows of ropes is represented by a list. Each element in the list represents a rope, and it is a list of integers that represent the length of segments of the rope.

Example:

Input: [[2,2,2,2],[1,4,3],[5,2,1]]
Output: 1
Explanation:

Assumptions:

The width sum of rope segments in different rows are the same and won't exceed 2147483647.
The length of a rope segment is larger than 0 and less than length of the rope.
