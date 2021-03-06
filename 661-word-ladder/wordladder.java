public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // S; O(n) T: num of word Length +  wordList length
    //Asumption: end word must be in the wordList， wordlist has no duplicates words
    Set<String> visited = new HashSet<>();
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
            List<String> neighbors = findNeighbors(cur,wordList);
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
    for(int i = 0; i < array.length; i++) {
      char cur = array[i];
      for(int j = 0; j < 26; j++) {
        char[] array = s.toCharArray();
        array[i] = ('a' + j);
        String str = new String(cur);
        if(dic.contains(str)){
          list.add(str);
        }
      }
      //每一次轮换完成以后，要换回原来的字母
      array[i] = cur;
    }
    return list;
  }
}
//DFS
//swap swap的时间复杂度比一个个字母general(h^n)好

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // Assume: end and begin word is in the wordList
    //T: O(n!) S: O(n)
    int[] res = new int[]{Integer.MAX_VALUE};
    //如果list是有Arrays.asList组成的，
    //实际上的list == array
    //那么list.add/list.remove都不work
    // if(!wordList.contains(endWord)) {
    //   wordList.add(endWord);
    // }
    for(int i = 0 ; i < wordList.size(); i++){
      if(wordList.get(i) == beginWord) {
        swap(wordList, i, 0);
      }
    }
    dfs(beginWord, endWord,wordList, 1, res);
    return res[0] == Integer.MAX_VALUE? 0: res[0];
  }
  private void dfs(String begin, String end, List<String> list, int index, int[] res) {
    if(list.get(index-1) == end) {
      res[0]= Math.min(res[0], index);
      return;
    }
    if(index == list.size()) {
      return;
    }
    for(int i = index; i < list.size(); i++) {
      if(valid(begin, list.get(i))) {
        swap(list,index, i);
        dfs(list.get(index), end, list, index+1, res);
        swap(list, index, i);
      }
    }
  }
  //my solution for valid
  // private boolean valid(String begin, String target){
  //   int diff = 0;
  //   for(int i = 0; i < begin.length; i++){
  //     if(begin.charAt(i) != target.charAt(i)){
  //       diff++;
  //     }
  //   }
  //   return diff == 1? true: false;
  // }
  private boolean valid(String begin, String target) {
    for(int i = 0; i < begin.length(); i++) {
      char[] cur = begin.toCharArray();
      for(int j = 0; j < 26; j++) {
        cur[i] = (char)('a'+j);
        if(target.equals(new String(cur))) {
          return true;
        }
      }
    }
    return false;
  }
  private void swap(List<String> list, int a, int b) {
    String temp = list.get(a);
    list.set(a,list.get(b));
    list.set(b,temp);
  }
}
