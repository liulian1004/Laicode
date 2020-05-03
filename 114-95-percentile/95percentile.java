public int percentile95(List<Integer> lengths) {
  // url [0,4095] 字节4k = 4 * 1024
  // url[i] represent how many urls of length i
  //T : O(1); S: O(1)
  if(lengths == null || lengths.size() == 0) {
    return 0;
  }
  if (lengths.size() == 1) {
    return 1;
  }
  // url长度4096， url[0]为空，所以总长度是4097
  int[] url = new int[4097];
  for(int i = 0; i <lengths.size(); i++) {
    int length = lengths.get(i);
    url[length] += 1;
  }
  int sum = 0;
  int i = 4097;
  //从尾巴开始计算比较快
  while(sum <= lengths.size() * 0.05) {
    //i是我这边需要返回的值，所以要先--
    i--;
    sum += url[i];
  }
  return i;

  }
}
