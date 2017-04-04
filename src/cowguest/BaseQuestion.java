package com.willscorpio.algorithm.cow;

import javax.management.Descriptor;

public class BaseQuestion {

	/**
	 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
     * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字
	 * @param mat 矩阵
	 * @param n 矩阵的行数
	 * @param m 矩阵的列数
	 * @return 最终的结果
	 */
	public static int[] ZhiMatrix(int[][] mat, int n, int m){
		int[] ans = new int[n*m];
		int key = 0;
		for(int i=0;i<n;i++){
				if(i%2==0){
					for(int j=0;j<m;j++){
					ans[key++] = mat[i][j];
					}
				}else{
					for(int j=m-1;j>=0;j--){
						ans[key++] = mat[i][j];
					}
				}
			}
		
		return ans;
	}
}
