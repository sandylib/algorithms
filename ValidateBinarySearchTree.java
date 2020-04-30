import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class ValidateBinarySearchTree {
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    if (!helper(node.right, val, upper)) return false;
    if (!helper(node.left, lower, val)) return false;
    return true;
  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

}



class Solution{

  public boolean isValidBST(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(),
                        lowers = new LinkedList();

      Integer val;
      stack.add(root);
      lowers.add(null);
      uppers.add(null);


    while (!stack.isEmpty()) {
      TreeNode  newRoot = stack.poll();
      Integer lower = lowers.poll();
      Integer upper = uppers.poll();

        if (newRoot == null) continue;
        val = newRoot.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        stack.add(newRoot.right);
        lowers.add(val);
        uppers.add(upper);

        stack.add(newRoot.left);
        lowers.add(lower);
        uppers.add(val);
      }
    return true;
  }


  public boolean isValidBST1(TreeNode root) {
    Stack<TreeNode> stack = new Stack();
    double inorder = - Double.MAX_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // If next element in inorder traversal
      // is smaller than the previous one
      // that's not BST.
      if (root.val <= inorder) return false;
      inorder = root.val;
      root = root.right;
    }
    return true;
  }
}

