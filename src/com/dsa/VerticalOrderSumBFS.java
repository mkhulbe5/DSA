package com.dsa;

import java.util.ArrayList;
import java.util.LinkedList;

public class VerticalOrderSumBFS {

	public ArrayList<Integer> vervticalOrderSum(TreeNode node) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (node == null) return ans;

		int[] minMax = new int[2];
		width(node,0,minMax);
		
		int len = minMax[1] - minMax[0];
		
		for(int i = 0; i < len; i++) {
			ans.add(0);
		}
		
		LinkedList<VPair> q = new LinkedList<>();
		q.addLast(new VPair(node, Math.abs(minMax[0])));
		
		
		while(q.size() != 0) {
			int size = q.size();
			
			while(size -- > 0) {
				VPair rp = q.removeFirst();
				
				TreeNode rpn = rp.node;
				int hl = rp.hl;
				
				ans.set(hl, ans.get(hl) + rpn.val);
				
				if(rpn.left != null)q.addLast(new VPair(rpn.left, hl - 1));
				if(rpn.right != null)q.addLast(new VPair(rpn.right, hl + 1));
			}
		}
		return ans;
		
	}
	
	
	public void width(TreeNode root,int hl, int[] ans) {
		if(root == null) return;
		
		ans[0] = Math.min(ans[0], hl);
		ans[1] = Math.max(ans[1], hl);
		
		width(root.left,hl - 1 , ans);
		width(root.right,hl + 1 , ans);
	}

}
