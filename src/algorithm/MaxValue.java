package algorithm;

/**
 * 一串数字中的最大值
 */
public class MaxValue {

	/**
	 * 使用穷举法来找出找出一段的最大和，复杂度为Θ(n^3)。暴力求解方法。
	 * @param arrayint int类型数组
	 * @return 和的值
	 */
	public static int bruteForceMaxValue(int[] arrayint){
		int MaxSum=0;
		for(int i=0;i<arrayint.length;i++){
			for(int j=i;j<arrayint.length;j++){
				int ThisSum=0;
				for(int k=i;k<=j;k++){
					ThisSum=ThisSum+arrayint[k];
				}
				if(ThisSum>MaxSum){
					MaxSum=ThisSum;
				}
			}
		}
		return MaxSum;
	}

	/**
	 * 求出一串整型数字的其中的一段最大和，这个比第一个好，复杂度是Θ(n^2)。暴力求解方法。
	 * @param arrayint int类型数组
	 * @return 最大值
	 */
	public static int bruteMaxValue(int[] arrayint){
		int MaxSum=0;
		for(int i=0;i<arrayint.length;i++){
			int ThisSum=0;
			for(int j=i;j<arrayint.length;j++){
				ThisSum+=arrayint[j];
				if(ThisSum>MaxSum){
					MaxSum=ThisSum;
				}
			}
		}
		return MaxSum;
	}

	/**
	 * 这个方法也是求出一串数字中的最大和，这个很有意思，但是这个最大和最终值必须大于0。扫描数组。
	 * 否则会有问题，复杂度是Θ(n)
	 * @param arrayint 整型数组
	 * @return 和的最大值
	 */
	public static int goodMaxValue(int[] arrayint){
		int MaxSum=0,ThisSum=0;
		for(int i=0;i<arrayint.length;i++){
			ThisSum+=arrayint[i];
			if(ThisSum>MaxSum){
				MaxSum=ThisSum;
			}else if(ThisSum<0){
				ThisSum=0;
			}
		}
		return MaxSum;
	}

	/**
	 * 分治查找最大子数组的一部分，这个是求出经过中点的最大子数组
	 * @param arrayInt
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	private static int[] middleMaxValue(int[] arrayInt, int low, int mid, int high) {

		int left_sum = Integer.MIN_VALUE;
		int right_sum = Integer.MIN_VALUE;
		int maxLeft = 0;
		int maxRight = 0;

		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum = sum + arrayInt[i];
			if (sum > left_sum) {
				left_sum = sum;
				maxLeft = i;
			}
		}

		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum = sum + arrayInt[i];
			if (sum > right_sum) {
				right_sum = sum;
				maxRight = i;
			}
		}

		return new int[]{maxLeft, maxRight, left_sum + right_sum};
	}

	/**
	 * 使用分治法求出最大子数组
	 *
	 * @param arrayInt
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] divideMaxValue(int[] arrayInt, int low, int high) {

		if (high == low) {
			return new int[]{low, high, arrayInt[low]};
		} else {
			int mid = (low + high) / 2;
			int[] leftSum = divideMaxValue(arrayInt, low, mid);
			int[] rightSum = divideMaxValue(arrayInt, mid + 1, high);
			int[] crossSum = middleMaxValue(arrayInt, low, mid, high);
			if (leftSum[2] >= rightSum[2] && leftSum[2] >= crossSum[2]) {
				return leftSum;
			} else if (rightSum[2] >= leftSum[2] && rightSum[2] >= crossSum[2]) {
				return rightSum;
			} else {
				return crossSum;
			}
		}
	}

}
