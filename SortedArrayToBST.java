
 public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
   return sortedArrayToBST(nums, 0, nums.length-1);
        
  }

  public TreeNode sortedArrayToBST(int arr[], int start, int end) { 
     if (start > end) { 
      return null; 
    } 
  int mid = (start + end) / 2; 
  TreeNode node = new TreeNode(arr[mid]); 
  /* Recursively construct the left subtree and make it 
   left child of root */
  node.left = sortedArrayToBST(arr, start, mid - 1); 

  /* Recursively construct the right subtree and make it 
   right child of root */
  node.right = sortedArrayToBST(arr, mid + 1, end); 
    
  return node; 
} 



}