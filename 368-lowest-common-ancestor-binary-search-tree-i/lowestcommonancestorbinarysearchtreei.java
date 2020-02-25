public TreeNode lca(TreeNode root, int p, int q) {
    // it's bst, leverage the feture of bst
    //返回的ancestor需要在[p,q]内，p > q
    //< p, 走到right去找； >q, 走到left去找
    int min= Math.min(p,q);
    int max = Math.max(p,q);
    while(root != null) {
      if(root.key < min) {
        root = root.right;
      } else if (root.key > max) {
        root = root.left;
      } else if (root.key == max || root.key > min && root.key < max) {
        return root;
      }
    }
    //p,q not in the tree of root
    return null;

}
}
