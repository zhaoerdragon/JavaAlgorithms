import algorithm.SortingAlgorithm;
import datastructute.MaxHeapify;
import sun.security.tools.keytool.CertAndKeyGen;
import utils.CreateArray;
import utils.MyOut;

public class MainFunction{
    public static void main(String[] args) {
        int[] arrayInt = CreateArray.createIntArray(10);

        MaxHeapify.heapSoft(arrayInt);

        MyOut.println(arrayInt);
    }

}