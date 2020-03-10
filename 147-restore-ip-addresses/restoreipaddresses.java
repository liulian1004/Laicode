public class Solution {
  public List<String> Restore(String ip) {
    // Ip地址的有效：
    //每一点最多3位
    //一位时任何数字都行
    //二位时不能有leading zero
    //三位时第一位时1，后面两位什么都行；第一位是2时，范围是200 ～ 255
    List<String> list = new ArrayList<>();
    if(ip == null || ip.length() < 4) {
      return list;
    }
    char[] array = ip.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(array,sb, 0,0, list);
    return list;
  }
  private void helper(char[] array, StringBuilder sb, int level, int offset, List<String> list) {
    if(level == 4) {
      if(sb.length() == array.length + 4) {
        //最后会加4个点 比如 0001 --？0.0.0.1.
        //所以要用substring来做
        //substring[start, end)
        list.add(sb.substring(0, sb.length()-1));
      }
      return;
    }
    //检查加在一个点加在三个不同位置的情况
    //每一层是分三个叉
    //点加在第一个位置
    if(offset < array.length){
      int length = sb.length();
      sb.append(array[offset]).append('.');
      helper(array, sb, level + 1, offset + 1, list);
      //delete[start, end)
      sb.delete(length, sb.length());
    }
    //点加在第二个位置
    if(offset + 1 < array.length) {
      char a = array[offset];
      char b = array[offset + 1];
      if(a != '0') {
        int length = sb.length();
        sb.append(a).append(b).append('.');
        helper(array, sb, level + 1, offset+2, list);
        sb.delete(length, sb.length());
      }
    }
    //点加在第三个位置
    if(offset+2 < array.length){
      char a = array[offset];
      char b = array[offset + 1];
      char c = array[offset + 2];
      if(a == '1' || a =='2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c >= '0' && c <= '5') {
        int length = sb.length();
        sb.append(a).append(b).append(c).append('.');
        helper(array, sb, level + 1, offset+3, list);
        sb.delete(length, sb.length());
      }
    }
  }
}
