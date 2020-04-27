Determine the length of the longest ascending path in the binary tree.

A valid path is a part of the path from root to any of the leaf nodes.

Examples:

        5

      /    \

    3        2

  /   \        \

1      0        11

the longest ascending path is 2 -> 11, length is 2.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
