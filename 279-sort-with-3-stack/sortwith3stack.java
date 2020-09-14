public class Solution {
  public void sort(LinkedList<Integer> s1) {
    //T: nlogn(same as classical merge sort)
    //s : O(n) -- > the upper bound of  s3
    //s1: input
    //s2: buffer, 放另外一半
    //s3: merge的时候放部分结果级
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();
    helper(s1, s2,s3, s1.size());
  }
  private void helper(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length ) {
        if(length <= 1) {
            return;
        }
        int mid = length / 2; // calculate the mid
        for(int i  = 0; i < mid; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        helper(s2,s3, s1, mid);
        helper(s1, s3, s2, length - mid);
        merge(s1,s2,s3, mid, length - mid, length);
   }
   // s1.length = length - mid because s1 ==> previous s2
    //s2.length = mid because s2 ===> previous s3
   private void merge(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int l1, int l2, int length){
        int i = 0; // i points to s2;
        int j = 0; // j points to s1
       //compare two elements and move the smaller one
        while(i < l1 && j < l2) {
            if(s2.peekFirst() < s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            }else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while(i < l1) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while(j < l2) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        // transfer from s3 to s1
       // the order will change from descending to ascending
        for(int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
   }

}
