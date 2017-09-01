import algorithm.SortingAlgorithm;
import cowguest.BaseQuestion;
import cowguest.DynamicAlgorithm;
import cowguest.LeetCodeQuestion;
import datastructute.MaxHeapify;
import sun.security.tools.keytool.CertAndKeyGen;
import utils.CreateArray;
import utils.MyOut;

public class MainFunction{
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 3, 4, 5, 5, 5, 8};
        int kinds = 1;
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] - arrays[i - 1] > 0) {
                kinds++;
            }
        }
        System.out.println("This kinds is " + kinds);
    }
}