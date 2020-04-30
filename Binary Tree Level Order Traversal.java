
public class BSTTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    
    List<List<Integer>> ans = new ArrayList<>();
    
    LinkedList<TreeNode> q = new LinkedList<>();
    q.add(root);
    
    while (!q.isEmpty()) {
        int len = q.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeNode curr = q.remove();
            list.add(curr.val);
            
            if (curr.left != null) {
                q.add(curr.left);
            }
            
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        
        ans.add(list);
    }
    
    return ans;
}

}