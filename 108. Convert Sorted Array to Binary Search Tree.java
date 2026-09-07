class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        // Base case: range is invalid
        if (left > right) {
            return null;
        }

        // Avoid integer overflow for mid calculation
        int mid = left + (right - left) / 2;
        
        // Middle element becomes the root
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct left and right subtrees
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
