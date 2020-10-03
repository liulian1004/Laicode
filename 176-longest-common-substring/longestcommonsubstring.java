public class Solution {
  public String longestCommon(String source, String target) {
    // m[i][j] present the longest commom substring from s1(0) till s1(i) and s2(0) till s2(j)
    // base case M[0][0]; M[i][0]; M[0][j] == 0
    //induction rule : S1[i-1] == s2[j-1] m[i][j] == m[i-1][j-1] + 1
    //  S1[i-1] != s2[j-1] m[i][j] = 0;
   //T: O(m*n) S: O(m*n)
   int[][] dp = new int[source.length()+1][target.length()+1];
   int end = 0;
   int max = 0;
   for(int i = 0; i <= source.length(); i++ ){
     for(int j =0 ; j<= target.length(); j++){
       //base case
       if(i == 0 || j == 0){
         //可以不写
         //dp[i][j] = 0;
         continue;
       }
       if(source.charAt(i-1) == target.charAt(j-1)){
         dp[i][j] = dp[i-1][j-1]+1;
       }
       if(dp[i][j] > max){
         end = i-1;
         max = dp[i][j];
       }
     }
   }
   //no common substring
   if(max == 0){
     return "";
   }
   return source.substring(end-max+1,end+1);
 }
}
