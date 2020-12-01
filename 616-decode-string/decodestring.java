public class Solution {
  public String decodeString(String s) {
    //T: o(n)*h s:o(h)
      StringBuilder sb = new StringBuilder();
        int[] index = new int[]{0};
        return dfs(s,index);
    }
    private String dfs(String s, int[] index){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(index[0] < s.length()){
            char c = s.charAt(index[0]);
            if(Character.isLetter(c)){
                sb.append(c);
                index[0]++;
            }else if(Character.isDigit(c)){
                while(Character.isDigit(s.charAt(index[0]))){
                    count = count*10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }
            }else if(c == '['){
                index[0]++;
                String temp = dfs(s, index);
                while(count > 0){
                    sb.append(temp);
                    count--;
                }
            }else if(c == ']'){
                index[0]++;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
