class Solution {

  public boolean isCousins(TreeNode root, int x, int y) {
    int heightX = findHeight(root, x, 0);
    int heightY = findHeight(root, y, 0);
    if (isSiblings(root, x, y) || (heightX != heightY)) {
      return false;
    } else if (heightX == heightY) {
      return true;
    }
    return false;
  }
  
  private int findHeight(TreeNode root, int x, int level) {
    if (root == null) {
      return 0;
    }
    if (root.val == x) {
      return level;
    }
    return Math.max(findHeight(root.left, x, level + 1) , findHeight(root.right, x, level + 1));
  }
  
  private boolean isSiblings(TreeNode root, int x, int y) {
    if (root == null) {
      return false;
    }
    return (root.left != null && root.left.val == x && root.right != null && root.right.val == y) ||
       (root.right != null && root.right.val == x && root.left != null && root.left.val == y) || 
         isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
     }


  }
  
  