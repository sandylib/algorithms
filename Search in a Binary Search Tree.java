public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
          
      if (root == null) {
          return root;
      }
      
      if(root.val == val) {
          return root;
      }
      
      if(val > root.val) {
          return searchBST(root.right, val);
      }
      
      return searchBST(root.left, val);
   }


   public TreeNode searchBSTTwo(TreeNode root, int val) {
    while(root != null) {
        if (root.val == val)
            return root;
        else if (val < root.val) 
            root = root.left;
        else 
            root = root.right;
    }
    
    return null;
  }
  
}