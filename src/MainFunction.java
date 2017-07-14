import algorithm.SortingAlgorithm;
import datastructute.MaxHeapify;
import utils.CreateArray;
import utils.MyOut;

public class MainFunction{
    public static void main(String[] args) {
        int[] arrayInt = CreateArray.createIntArray(10);
        MaxHeapify.heapSort(arrayInt);

        MyOut.println(arrayInt);
    }
}