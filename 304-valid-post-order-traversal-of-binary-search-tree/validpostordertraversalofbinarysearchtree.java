public class Solution {
  public boolean validPostOrder(int[] post) {
    //recursion： 查每一层是否符合要求
    int n = post.length-1;
    int left = 0;
    return helper(post,0,n);
  }
  private boolean helper(int[] post, int left, int right){
    //left > right => corner case when the post is empty
    if(left >= right){
      return true;
    }
    int root = post[right];
    int k = left;
    int length = right - left;
    while(k <= length && post[k] < root){
      k++;
    }
    for(int i = k; i < length;i++){
      if(post[i] <= root){
        return false;
      }
    }
    return helper(post, left, k-1) && helper(post, k, right-1);
  }
}
