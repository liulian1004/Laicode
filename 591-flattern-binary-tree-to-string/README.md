591. Flatten Binary Tree to String
Easy
Given an binary tree, try to flatten it following the requirements below:

Traverse the binary tree in preorder.
If a TreeNode has child(children), put it (them) into parenthesis.
When it is necessary to represent a null node to make sure the tree is represented correctly without ambiguity, use empty parenthesis "()" .
Example 1:

Input: [1,2,3,4]

        1

      /   \

    2      3

  /

4

Output: "1(2(4))(3)"

Example 2:

Input: [1,2,3,null, null, null, 4]

        1

      /   \

    2      3

              \

                4

Output: "1(2)(3()(4))"
