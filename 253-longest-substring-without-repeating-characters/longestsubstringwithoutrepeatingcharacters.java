public int longest(String input) {
  // T: O(n) S: O(n)
  // i = slow, j = fast
  // assume there is not space between the charachter
  //把input转换成char【】时间复杂度并不增加
  if(input == null || input.length() == 0) {
    return 0;
  }
  int i = 0;
  int distance = 0;
  int j = 0;
  Set<Character> set = new HashSet<>();
  while(j < input.length()) {
    //if it has the repeated characters,
    //remove chars and i start to move until no repeated characters
    if(set.contains(input.charAt(j))) {
      // remeber to remove charAt(i)
      set.remove(input.charAt(i));
      i++;
    } else {
      set.add(input.charAt(j));
      j++;
      // global size
      //only calcuate the silding windows when the j moves
      distance = Math.max(distance, j - i);
    }
  }
  return distance;
}
}
