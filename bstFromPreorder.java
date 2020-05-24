public class Solution {
  int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    TreeNode helper(int[] preorder, int min, int max){
        if(index >= preorder.length){
            return null;
        }
        
        int key = preorder[index];
        TreeNode node = null;
        if(key > min && key < max){
            node = new TreeNode(preorder[index]);
            index++;
            node.left = helper(preorder, min, key);
            node.right = helper(preorder, key, max);
        }
        return node;
    }
  
}