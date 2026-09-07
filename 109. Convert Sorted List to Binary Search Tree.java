class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Base cases
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find the middle element using slow and fast pointers
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' is now at the middle node, which will be the root
        TreeNode root = new TreeNode(slow.val);

        // Disconnect the left half from the middle node
        if (prev != null) {
            prev.next = null;
        }

        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
