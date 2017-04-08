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

	/**
	 * 桶排序
	 */
	public static void tunSort(){
		int[] a = new int[]{102,123,123,143,187,199,167,155,123};
		int min = a[0], max = a[0];
		for(int i = 0;i<a.length;i++){
			if(a[i]>max) max = a[i];
			if(a[i]<min) min = a[i];
		}

		int length = max - min + 1;
		int[] sort = new int[length];
		for(int i = 0;i<a.length;i++){
			sort[a[i] - min]++;
		}
		for(int i = 0;i<sort.length;i++){
			if(sort[i] == 0) continue;
			else {
				for(int j = 0;j<sort[i];j++){
					System.out.print(" "+ (i+min) +" ");
				}
			}
		}
	}
}
