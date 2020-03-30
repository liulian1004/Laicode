public class Solution {
  //T: O(n!) S: O(n)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> list = new ArrayList<>();
      //只要查endword在不在dic里面
      //beginword回在初始化的时候加入
        if (!wordList.contains(endWord)) {
          return list;
        }
        // Map<curword, level>
        Map<String, Integer> visited = new HashMap<>(); //S： O(n)
        //Map<generated word, prev-word>
        Map<String, List<String>> pre = new HashMap<>();//S： O(n)
        Set<String> dic = new HashSet<>();
         for(String s: wordList){ // T: O(n)
             //初始化dic
             dic.add(s);
             //初始化pre
             pre.put(s, new ArrayList<>());
         }
         bfs(beginWord,endWord, dic,pre,visited);
         dfs(beginWord,endWord,pre,visited, new ArrayList<String>(),list); // T: O(n!)
         return list;
     }
     private void dfs(String beginWord, String endWord,Map<String, List<String>> pre,Map<String, Integer> visited,List<String> cur, List<List<String>> list) {
        //从end开始往beginword travesal
        if(endWord.equals(beginWord)) {
            //旋转cur，让结果从头到尾
            cur.add(endWord);
           // System.out.println("cur" + cur);
            Collections.reverse(cur);
            list.add(new ArrayList<>(cur));
            //旋转回cur
            Collections.reverse(cur);
            cur.remove(cur.size()-1);
            return;
        }
        for(String previous: pre.get(endWord)) {
            if(visited.containsKey(previous) && visited.get(previous) + 1 == visited.get(endWord)) {
                cur.add(endWord);
                dfs(beginWord, previous,pre,visited,cur, list);
                cur.remove(cur.size()-1);
            }
        }
     }
    public void bfs(String beginWord, String endWord, Set<String> dic,Map<String, List<String>> pre,Map<String, Integer> visited) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.put(beginWord, 0);
        //pre.put(beginWord, new ArrayList<String>());
        while(!queue.isEmpty()) {
            int size = queue.size();
            String cur = queue.poll();
                List<String> neighbors = findNeighbors(cur,dic);
                for(String nei: neighbors) {
                    //无论是否visited过，都需要更新pre map
                    pre.get(nei).add(cur);
                    if(!visited.containsKey(nei)){
                        visited.put(nei, visited.get(cur) + 1);
                        queue.offer(nei);
                    }
                }
            }
        }
    //}
    private List<String> findNeighbors(String s, Set<String> dic) {
        List<String> list = new ArrayList<>();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < 26; j++) {
                char[] cur = array.clone();
                cur[i] = (char)('a' + j);

                String str = new String(cur);
               // System.out.println("str "+ str);
                if(dic.contains(str)){
                    list.add(str);
                }

            }
        }
        return list;
    }
}
