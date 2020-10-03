public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    // Write your solution here
    int dis = Integer.MAX_VALUE;
    int a = -1;
    int b = -1;
    for(int i = 0; i < words.length;i++){
        if(words[i].equals(word1)){
          a = i;
        }
        if(words[i].equals(word2)){
          b = i;
        }
        if(a != -1 && b != -1){
          dis = Math.min(dis, Math.abs(a-b));
        }
    }

    return dis;
  }
}
