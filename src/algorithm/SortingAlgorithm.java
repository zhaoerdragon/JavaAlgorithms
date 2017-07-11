package algorithm;

/**
 * 排序算法类库
 */
public class SortingAlgorithm {

	/**
	 * 升序的冒泡排序
	 */
	public static int[] bubbleSort(int[] arrayint){
		for (int i = 0; i < arrayint.length; i++) {
			for (int j = i + 1; j < arrayint.length; j++) {
				int sample = 0;
				if (arrayint[j] > arrayint[i]) {
					sample = arrayint[j];
					arrayint[j] = arrayint[i];
					arrayint[i] = sample;
				}
			}
		}
		return arrayint;
	}

	/**
	 * 升序的插入排序
	 */
	public static int[] insertionSort(int[] arrayint) {
		for (int i = 1; i < arrayint.length; i++) {
			int key = arrayint[i];
			int j = i - 1;
			while (j >= 0 && arrayint[j] > key) {
				arrayint[j + 1] = arrayint[j];
				j--;
			}
			arrayint[j + 1] = key;
		}

		return arrayint;
	}

	/**
	 * 升序的桶排序
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

	/**
	 * 升序的归并排序
	 * @param arrayInt
	 * @return
	 */
	public static int[] mergeSoft(int[] arrayInt) {

		return null;
	}
}
