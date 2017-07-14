package datastructute;

/**
 * 二叉堆中的最大堆
 */
public class MaxHeapify {

    /**
     * 维护堆的性质
     * @param arrayInt
     * @param sign
     */
    public static void maxHeapify(int[] arrayInt, int sign) {
        int left = 2 * sign;
        int right = 2 * sign + 1;
        int largest;
        if ((left < arrayInt.length) && (arrayInt[left] > arrayInt[sign])) {
            largest = left;
        } else {
            largest = sign;
        }
        if ((right < arrayInt.length) && (arrayInt[right] > arrayInt[sign])) {
            largest = right;
        }
        if (largest != sign) {
            int temp = arrayInt[largest];
            arrayInt[largest] = arrayInt[sign];
            arrayInt[sign] = temp;
            maxHeapify(arrayInt, largest);
        }
    }

    /**
     * 建堆
     * @param arrayInt
     */
    public static void buildMaxHeap(int[] arrayInt) {
        for (int i = arrayInt.length / 2; i >= 0; i--) {
            maxHeapify(arrayInt, i);
        }
    }

    /**
     * 升序的堆排序(最大堆),最小堆用来实现优先队列。
     * @param arrayInt
     */
    public static void heapSort(int[] arrayInt) {
        for (int i = arrayInt.length - 1; i > 0; i--) {
            int temp = arrayInt[i];
            arrayInt[i] = arrayInt[1];
            arrayInt[1] = temp;
            maxHeapify(arrayInt, 1);
        }
    }
}
