579. Find Common Elements In Two Lists with Minimum Index Sum
Easy
Mary and Max are looking for job opportunities and practicing on Laicode together. Both of them have a list of dream companies. The lists are represented by two String array. Please help them to find their common interest companies so that the sum of the index is as small as possible. The output is an array of String and should be sorted in alphabetical order.

Example 1:

Input: list1 = ["amazon", "microsoft", "linkedin", "google"]; list2 = ["stark", "intel", "amd", "amazon"]

Output: ["amazon"]

Explanation: There is only one common company ["amazon"] in the two lists.

Example 2:

Input: list1 = ["amazon", "microsoft", "linkedin", "google"]; list2 = ["stark", "intel", "amd", "amazon","microsoft"]

Output: ["amazon"]

Explanation: There are two common companies in the two lists, "amazon" and "microsoft". Sum of index is 3 for "amazon" and 5 for "microsoft", so that the output is  ["amazon"].

Example 3:

Input: list1 = ["amazon", "microsoft", "linkedin", "google"]; list2 = ["stark", "intel", "microsoft", "amazon"]

Output: ["amazon","microsoft"]

Explanation:There are two common companies in the two lists, "amazon" and "microsoft". Sum of index of both of them is 3, so return both of them in alphabetical order.
