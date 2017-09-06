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
        int[] arrayInt = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5};
        int count = LeetCodeQuestion.singleNumber(arrayInt);
        System.out.println("得到的结果是:" + count);
    }
}