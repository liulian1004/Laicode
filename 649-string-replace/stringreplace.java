public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    char[] array = input.toCharArray();
    if(source.length() >= target.length()) {
      return shortReplace(array, source, target);
    }
    return longReplace(array, source, target);

  }

  private String shortReplace(char[] array, String source, String target) {
    int s = 0;
    int f = 0;
    while(f < array.length) {
      //f can move to max(array.length - source.length())
      //no need to continue to check after that index
      if(f <= array.length - source.length() && equals(array, source, f)) {
        replace(array, target, s);
        // replace the lenght of target
        s = s + target.length();
        // repalce the length of source
        f = f + source.length();
      } else {
        // copy if don't need to replace
        array[s++] = array[f++];
      }
    }
    return new String(array, 0, s);
  }

  private String longReplace(char[] array, String source, String target) {
    List<Integer> match = matchFinder(array, source);

    char[] res = new char[array.length + match.size() * (target.length()- source.length())];
    int s = res.length - 1;
    int f = array.length - 1;
    int lastIndexOfMatch = match.size() - 1;
    while(f >= 0) {
      if(lastIndexOfMatch >= 0 && f == match.get(lastIndexOfMatch)) {
        //s从后往前走，copy的时候要先走到前面开始copy
        replace(res, target, s - target.length() + 1);
        s = s - target.length();
        f = f - source.length();
        lastIndexOfMatch--;
      } else {
        res[s--] = array[f--];
      }
    }
    return new String(res);

  }

  private List<Integer> matchFinder(char[] array, String source) {
    List<Integer> match = new ArrayList<>();
    int i = 0;
    //最多查到对尾之前s.length()的index
    while(i <= array.length - source.length()) {
      if(equals(array, source, i)) {
        //记录在math的结束index位置，因为i已经在source.length里面，所以要减一位
            match.add(i+source.length() - 1);
            i = i+source.length();
      } else {
        i++;
      }
    }
    return match;
  }
  private boolean equals(char[] array, String source, int f ) {
    for(int i = 0; i < source.length(); i++) {
        if(array[f + i] != source.charAt(i)) {
          return false;
        }
    }
    return true;
  }

  private void replace(char[] array, String target, int s) {
      for(int i = 0; i < target.length(); i++) {
        array[s+i] = target.charAt(i);
      }
  }

}
