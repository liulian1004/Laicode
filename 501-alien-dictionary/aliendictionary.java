public class Solution {
  public String alienOrder(String[] words) {
    //T: O(m*n) S: O(1)
    // dfs:T: 25!*h S: O(h)==> max 26
    //grap[i][j] true, represent for the i-th letter, the j-th letter is adject with i-th letter
    // visited[i] : 0"not have the dictonary; '1' in the dictornary but not travsal
    //"2" has travsal before, so it's has a circual here, not quailfy
    //"3" the qualify one, only traval once

    boolean[][] graph = new boolean[26][26];
    int[] visited = new int[26];
    //build graph and visted
    for(int i = 0 ; i < words.length; i++) {
      //build visited
      for(char c: words[i].toCharArray()) {
        int temp = c -'a';
        visited[temp] = 1;
      }
      if(i ==0) {
        continue;
      }
      //build graph
      String s1 = words[i-1];
      String s2 = words[i];
      boolean gotDif = false;
      for(int j = 0; j < s1.length(); j++) {
        char c1 = s1.charAt(j);
        char c2 = s2.charAt(j);
        if(c1 != c2 ) {
          graph[c1-'a'][c2-'a'] = true;
          gotDif = true;
          break;
        }
      }
      // s1 比s2短，且短的部分字母重复
      if(gotDif == false) {
        //查看s2里的不同字母
        for(int j = s1.length(); j < s2.length(); j++ ) {
            char c1 = s2.charAt(j-1);
          char c2 = s2.charAt(j);
          if(c1 != c2 ) {
            graph[c1-'a'][c2-'a'] = true;
            break;
          }
        }
      }
    }
    //dfs
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 26; i++) {
      //从出现的第一个letter开始看
      if(visited[i] == 1) {
        if(!dfs(i,visited, graph, sb)){
            return "";
        }
      }
    }
    return sb.reverse().toString();
  }
  private boolean dfs(int cur, int[] visited, boolean[][] graph, StringBuilder sb) {
    //visited the char before, return false
    if(visited[cur] == 2) {
      return false;
    }
    // this is a qualifey letter and added in the sb, not need to visited again
    if(visited[cur] == 3) {
      return true;
    }
    // mark as visited
    visited[cur] = 2;
    for(int i = 0; i < 26; i++) {
      if(graph[cur][i] == true) {
        if(!dfs(i, visited, graph, sb)) {
          return false;
        }
      }
    }
    visited[cur] = 3;
    sb.append((char)(cur + 'a'));
    return true;
  }
}
