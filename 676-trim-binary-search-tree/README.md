676. Trim Binary Search Tree
Easy
Given a root node of binary search tree, a lower bound and an upper bound, remove nodes that are outside of [lower, upper]. Return the root node after trimming the binary search tree. The root returned may not the same as the given root node.

Example:

Input: root = [5,2,8,1,3,6,9]   lower = 2, upper = 4

                  5       

                /    \

              2       8

            /   \    /  \

           1   3   6    9

Output: [2, null, 3]

                 2

                    \

                      3
