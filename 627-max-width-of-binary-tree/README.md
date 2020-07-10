627. Maximum Width of Binary Tree
Easy
The width of a level in a tree is defined as the length of current level including null nodes between normal nodes.

Given a binary tree, return the maximum width among all levels in the tree.

Example 1:     1

                     /      \

                   2         3

                 /  \       /  \

              4     5    6     null

Output: 3

Explanation: The maximum width is width of level [4, 5, 6].

Example 2:     1

                     /      \

                   2          3

                 /  \        /  \

              4    null  null   5

Output: 4

Explanation: The maximum width is width of level [4, null, null, 5]. Null nodes between valid nodes are included when calculating width.

Example 3:     1

                     /      \

                   2          3

                 /  \        /       \

              null null null     4

Output: 4

Explanation: The maximum width is width of level [2, 3].
