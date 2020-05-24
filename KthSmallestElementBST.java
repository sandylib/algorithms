import java.util.Stack;

class Solution {
  public int kthSmallest(TreeNode root, int k) {
      int[] arr = new int[k];
      TreeNode node = root;
      int position = 0;
      Stack<TreeNode> stack = new Stack<>();
      
      while(!stack.isEmpty() || node != null){
          while(node != null){
              stack.push(node);
              node = node.left;
          }
          node = stack.pop();
          if(position < k){
              arr[position++] = node.val;
          } else {
              break;
          }
          node = node.right;
      }
      return arr[position-1];
      
  }
}

class Solution2 {
  public int kthSmallest(TreeNode root, int k) {
     int[] nums = new int[2];
      inorder(root, nums, k);

      return nums[1];
  }

  public void inorder(TreeNode root, int[] nums, int k){
    if(root == null) return ;

    inorder(root.left, nums, k);

    if(++nums[0] == k){
       nums[1] = root.val;
       return ;
    }
    
    inorder(root.right, nums, k);
  }

}