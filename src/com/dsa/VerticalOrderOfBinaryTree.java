package com.dsa;

import java.util.ArrayList;
import java.util.LinkedList;

public class VerticalOrderOfBinaryTree {

	
	public ArrayList<ArrayList<Integer>> vobt(TreeNode root){
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if(root == null)return ans;
		
		
		int[] minMax = new int[2];
		width(root, 0, minMax);
		int len = minMax[1] - minMax[0];
		
		
		for(int i= 0; i < len ; i++) {
			ans.add(new ArrayList<>());
		}
		
		LinkedList<VPair> q = new LinkedList<>();
		q.addLast(new VPair(root,Math.abs(minMax[0])));
		
		
		
		while(q.size() != 0) {
			int size = q.size();
			
			while(size -- > 0) {
				VPair rp = q.removeFirst();
				int hl = rp.hl;
				
				TreeNode node = rp.node;
				ans.get(hl).add(node.val);
				
				
				if(node.left != null)q.addLast(new VPair(node.left ,hl- 1));
				if(node.right != null)q.addLast(new VPair(node.right ,hl+1));
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
