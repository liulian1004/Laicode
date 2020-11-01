public class Solution {
  static final int[][] dirt = {{-1,0},{1,0},{0,1},{0,-1}};
  public List<String> findWords(char[][] board, String[] words) {
    // T: O(word(Length * number of word) + m*n* 4^L(the longest  length of word)(dfs))
  //S: O(row*col + the longest  length of word)
    //trie：前缀数，每一个节点代表一个pre
    List<String> list = new ArrayList<>();
    if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
      return new ArrayList<>();
    }

    TrieNode root = build(words);
    //防止路径重复
    Set<String> set = new HashSet<>();
    //这两个可以放在for loop外面，因为每一次吃吐都会清空
    StringBuilder sb = new StringBuilder();
    boolean[][] visited = new boolean[board.length][board[0].length];
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        helper(board, visited, i,j,root, set, sb);
      }
    }
    return new ArrayList<>(set);
  }
  class TrieNode{
  //S: O(n*l), 如果tree比较密集型，这个总的空间比下面一种方法好，因为array的overhead比map少
  //children,存放下一层的节点
      TrieNode[] children = new TrieNode[26];
      boolean isWord = false;
  }
  //另一种常规的trie node接口
  //S: O(n*l)，用于比较稀疏的tree
  // class TrieNode{
  //     Map<Character, TrieNode> children;
  //     boolean isWord = false;
  //    int value; //option : 代表完整的值或者string
  // }
  private void helper(char[][] board, boolean[][] visited, int i, int j, TrieNode root, Set<String> set, StringBuilder sb) {
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true) {
      return;
    }
    char c = board[i][j];
    root = root.children[c-'a'];
    //如果是null，直接返回，不需要update sb 和 visit
    if(root.children[c -'a'] == null){
      return;
    }
    //吃
    sb.append(c);
    visited[i][j] = true;
    root = root.children[c-'a'];
    //这里找到word以后不用返回，继续找下一个word
    if(root.isWord) {
      set.add(sb.toString());
    }
    for(int[] dir: dirt) {
      int nextI = dir[0] + i;
      int nextJ = dir[1] + j;
      helper(board, visited, nextI, nextJ, root, set, sb);
    }
    //吐
    visited[i][j] = false;
    sb.deleteCharAt(sb.length()- 1);
  }

  private TrieNode build(String[] words) {
    TrieNode root = new TrieNode();
    for(String s: words) {
      TrieNode cur = root;
      for(int i = 0; i < s.length(); i++) {
        if(cur.children[c-'a'] == null){
           cur.children[c-'a'] = new TreeNode();
        }
        cur = next;
      }
      cur.isWord = true;
    }
    return root;
  }

}
