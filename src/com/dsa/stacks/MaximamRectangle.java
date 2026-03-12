package com.dsa.stacks;

import java.util.Stack;

public class MaximamRectangle {

	
    public int maximalRectangle(char[][] matrix) {
        
        int ans[] = new int[matrix[0].length];

        for(int i = 0; i < matrix[0].length;  i++){
            ans[i] = matrix[0][i];
        }

        int area = largestAres(ans);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                        ans[j]++;
                }else{
                        ans[j] = 0;
                }
            }
            area = Math.max(area,largestAres(ans));
        }
        return area;
    }

    public int largestAres(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;

        for(int i = 0; i < arr.length - 1; i++){
            int val = i == arr.length?0:arr[i];
            while(st.size() > 0  && arr[st.peek()] >= val){
                int rm = i;
                int h = arr[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea,h *(rm - lm - 1));
            }
            st.push(i);
        }
        return maxArea;
    }
}
