public class Solution {
  public boolean isWord(char[][] board, String word) {
    // T: (m*n*L^4) S: m*n + l
      if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board,word,i,j,0,visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word,int i, int j, int level, boolean[][] visited) {
         if(level == word.length()) {
            return true;
        }
        char temp = word.charAt(level);
        if(i < 0 ||i >= board.length || j < 0 || j >= board[0].length || board[i][j] != temp || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(helper(board, word, i+1,j,level+1,visited) || helper(board, word, i,j+1,level+1,visited)
            || helper(board, word, i-1,j,level+1,visited) || helper(board, word, i,j-1,level+1,visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
  }
