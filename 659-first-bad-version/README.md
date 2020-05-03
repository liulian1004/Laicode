Suppose there is a version control interface contains n versions of product [1,2,3,....n] (n >= 1).

Also there is an API called isBadVersion(int n) in which input is version number and output is boolean representing that whether the version is bad or not. Versions after the first bad version are all bad. Versions before the first bad version are all good.

Write a new API called findFirstBadVersion(int n) where n is the total number of versions that returns the version number of the first bad one. You can call isBadVersion(int n) in your code.

Please try to minimize the total number of isBadVersion() calls.

Example:

Suppose n = 5 and version 3 is the first bad version.

isBadVersion(1) = false;

isBadVersion(2) = false;

isBadVersion(3) = true;

So your api findFirstBadVersion(5) should return 3.
