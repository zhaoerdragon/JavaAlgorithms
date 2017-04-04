package base;

/**
 * 排序算法类库
 */
public class SortingAlgorithm {
	
	/**
	 * 冒泡算法
	 */
	public static int[] BubbleSort(int[] arrayint){
		for(int i=0;i<arrayint.length;i++){
			for(int j=i+1;j<arrayint.length;j++){
				int sample=0;
				if(arrayint[j]>arrayint[i]){
					sample=arrayint[j];
					arrayint[j]=arrayint[i];
					arrayint[i]=sample;
				}
			}
		}
		return arrayint;
	}

	/**
	 * 选择排序
	 */
	public static int[] SelectSort(int[] arrayint){
		for(int i=1;i<arrayint.length;i++){
			int key=arrayint[i];
			int j=i-1;
			while(j>=0&&arrayint[j]>key){
				arrayint[i+1]=arrayint[i];
				j--;
			}
			arrayint[j+1]=key;
		}
	
		return arrayint;
	}
}
