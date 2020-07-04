import java.util.*;

public class Solution {
  
  List<String> list = new ArrayList<>();
  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    int res = 0;
    helper(root, "");
    for (String item: list) {
        res += Integer.parseInt(item);
    }
    return res;
}
private void helper(TreeNode root, String sum) {
    if (root.left == null && root.right == null) list.add(sum + root.val);
    else {
        if (root.left != null) helper(root.left, sum + root.val);
        if (root.right != null) helper(root.right, sum + root.val);
    }
}

}