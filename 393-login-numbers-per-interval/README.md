393. Login Numbers Per Interval
Medium
Given a list of login sessions with start and end timestamps.

Get the list of intervals with number of users logged in. Intervals with 0 number of users logged in should not be included.

Examples:

login sessions: [[1, 2], [0, 4], [5, 6]]

return [[0, 1, 1], [1, 2, 2], [2, 4, 1], [5, 6, 1]]

at (0, 1) there is 1 user logged in.

at (1, 2) there is 2 user logged in.

at (2, 4) there is 1 user logged in (one user logged out at 2).

at (5, 6) there is 1 user logged in.
