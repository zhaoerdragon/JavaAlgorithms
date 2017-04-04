package cowguest;

/**
 * 这个类用来存储牛客网上基本问题的答案
 */
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

    /**
     * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
     *
     * 测试样例：
     * [[1,2,3],[4,5,6],[7,8,9]],3
     * 返回：[[7,4,1],[8,5,2],[9,6,3]]
     */
	public static int[][] rotateMatrix(int[][] mat, int n) {
	    int[][] ans = new int[n][n];


	    return null;
	}
}
