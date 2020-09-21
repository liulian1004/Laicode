public class Solution {
  public List<String> generatePalindromes(String input) {
    // build map <character, num of character>
        //check how many characters are odd, if over two, impossible to palindrome
        //build palindrome by dfs
        //step 1: insert the odd character first, append the even character and reduce 2 in map
        //step 2: once map is empty, build another half plindrome in the base case
        int[] base = new int[256];
        for(char c: input.toCharArray()){
            base[c]++;
        }
        //出现odd的次数
        int odd = 0;
        //初始化 unqiue char
        String unique = null;
        //初始化结果集
        List<String> list = new ArrayList<>();
        for(int i = 0; i < base.length;i++){
            if(base[i] % 2 == 1){
                if(odd == 0) {
                  char c = (char)(i);
                    unique = Character.toString(c) ;
                    odd++;
                }else{
                    return list;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        helper(sb, list,base,input.length()/2, unique);
        return list;
    }
    private void helper(StringBuilder sb, List<String> list, int[] base, int length, String unique){
        if(sb.length() == length){
          StringBuilder temp = new StringBuilder(sb);
            if(unique != null){
                list.add(temp.toString() + unique+ temp.reverse().toString());
            }else{
                list.add(temp.toString() + temp.reverse().toString());
            }

            return;
        }
        for(int i = 0; i < base.length;i++){
            int temp = base[i];
            if(temp >= 2){
                char c = (char) (i);
                sb.append(c);
                base[i] -= 2;
                helper(sb, list,base,length,unique);
                sb.deleteCharAt(sb.length()-1);
                base[i] += 2;
            }
        }
    }
}
