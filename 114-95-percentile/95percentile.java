public int percentile95(List<Integer> lengths) {
    // url [0,4095]
    // histogram[i] represent how many urls of length i
    //T : O(1); S: O(1)
    if(lengths == null || lengths.size() == 0) {
      return 0;
    }
    if(lengths.size() == 1) {
      return 1;
    }
    int[] histogram = new int[4096];
    for(int i = 0; i < lengths.size(); i++) {
          histogram[lengths.get(i)] += 1;
    }
    // prefix sum of histogram, if it's over 95%, return
    int sum = 0;
    int i = 0;
    for(; i < 4095; i++) {
        sum = sum + histogram[i];
        if(sum >= (0.95 * lengths.size())) {
          return i;
        }
    }
    return 0;

  }
}
