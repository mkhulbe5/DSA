package com.dsa;

public class WidthOfBinaryTree {

	public int widhtofBinaryTree(TreeNode root) {
		int[] ans = new int[2];
		width(root, 0, ans);
		int maxWidth = ans[1] - ans[0] + 1;
		return maxWidth;

	}

	private void width(TreeNode root, int hl, int[] ans) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		ans[0] = Math.min(ans[0], hl);
		ans[1] = Math.max(ans[1], hl);
		width(root.left, hl - 1, ans);
		width(root.right, hl + 1, ans);

	}
}
