public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // S; O(n) T: num of word Length +  wordList length
    Set<String> visited = new HashSet<>();
    Set<String> dic = new HashSet<>();
    for(String s: wordList){
      dic.add(s);
    }
    Queue<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    visited.add(beginWord);
    //起始值是1
    int level = 1;
    while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            String cur = queue.poll();
            if(cur.equals(endWord)) {
              return level;
            }
            List<String> neighbors = findNeighbors(cur,dic);
            for(String nei: neighbors) {
              if(visited.add(nei)){
                queue.offer(nei);
              }
            }
        }
        level++;
    }
    return 0;
  }
  //找到每一个cur的generate的可能性
  //每一位的字母转化成另一个字母，每转化一次，查下dic里面有没有
  //并且是要一位位转化
  private List<String> findNeighbors(String s, Set<String> dic) {
    List<String> list = new ArrayList<>();
    char[] array = s.toCharArray();
    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < 26; j++) {
        char[] cur = array.clone();
        cur[i] = (char)('a' + j);
        String str = new String(cur);
        if(dic.contains(str)){
          list.add(str);
        }
      }
    }
    return list;
  }
}
