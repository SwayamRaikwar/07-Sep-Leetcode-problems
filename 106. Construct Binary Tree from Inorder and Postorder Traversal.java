import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderMap = new HashMap<>();

        // Store element -> index mappings for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int inStart, int inEnd) {
        // Base case: no elements left in current range
        if (inStart > inEnd) {
            return null;
        }

        // The current root is the last element in current postorder range
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder array
        int inIndex = inorderMap.get(rootVal);

        // Construct right subtree FIRST (since postorder processes Right before Left backwards)
        root.right = buildTreeHelper(postorder, inIndex + 1, inEnd);
        root.left = buildTreeHelper(postorder, inStart, inIndex - 1);

        return root;
    }
}
