package algorithm;

/**
 * 一串数字中的最大值
 */
public class MaxValue {

	/**
	 * 使用穷举法来找出找出一段的最大和，复杂度为Θ(n^3)。
	 * @param arrayint int类型数组
	 * @return 和的值
	 */
	public static int bruteForce(int[] arrayint){
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
	 * 求出一串整型数字的其中的一段最大和，这个比第一个好，复杂度是Θ(n^2)
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
	 * 这个方法也是求出一串数字中的最大和，这个很有意思，但是这个最大和最终值必须大于0，
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

}
