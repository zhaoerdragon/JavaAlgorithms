package com.xupt.willscorpio.datastructute;

/**
 * 二叉堆中的最大堆
 * 堆排序
 */
public class MaxHeapify {

    /**
     * 堆排序
     * @param arrayInt
     */
    public static void heapSoft(int[] arrayInt) {
        int heapSize = arrayInt.length - 1;
        for (int i = arrayInt.length / 2; i >= 0; i--) {
            maxHeap(arrayInt, heapSize, i);
        }
        for (int i = arrayInt.length - 1; i > 0; i--) {
            int temp = arrayInt[i];
            arrayInt[i] = arrayInt[0];
            arrayInt[0] = temp;
            heapSize = heapSize - 1;
            maxHeap(arrayInt, heapSize, 0);
        }
    }

    /**
     * 维护堆的性质，假定左右子数都是二叉堆的情况下，整理结点
     * @param arrayInt
     * @param heapSize
     * @param sign
     */
    private static void maxHeap(int[] arrayInt, int heapSize, int sign) {
        int left = sign * 2;
        int right = sign * 2 + 1;
        int largest;

        if (left <= heapSize && arrayInt[left] > arrayInt[sign]) {
            largest = left;
        }else {
            largest = sign;
        }
        if (right <= heapSize && arrayInt[right] > arrayInt[largest]) {
            largest = right;
        }

        if (largest != sign) {
            int temp = arrayInt[largest];
            arrayInt[largest] = arrayInt[sign];
            arrayInt[sign] = temp;
            maxHeap(arrayInt, heapSize, largest);
        }
    }

}
