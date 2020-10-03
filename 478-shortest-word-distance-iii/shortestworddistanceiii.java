public class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    // Write your solution here

    int dis = Integer.MAX_VALUE;
    int a = -1;
    int b = -1;
    boolean flag = false;
    for(int i = 0; i < words.length;i++){
        if(word1.equals(word2) && !flag && words[i].equals(word1)||
         !word1.equals(word2) && words[i].equals(word1)){
          a = i;
          flag = true;
        }else if(word1.equals(word2) && flag && words[i].equals(word2) ||
        !word1.equals(word2) && words[i].equals(word2)){
          b = i;
          flag = false;
        }
        if(a != -1 && b != -1){
          dis = Math.min(dis, Math.abs(a-b));
        }
    }

    return dis;
  }
}
