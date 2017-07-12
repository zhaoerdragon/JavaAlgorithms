import algorithm.SortingAlgorithm;
import utils.CreateArray;
import utils.MyOut;

/**
 * 这是整个包的主函数，用来验证代码算法是否正确
 */


public class MainFunction {

    public static void main(String[] args) {
        int[] arrayInt = CreateArray.CreateIntArray(30);

        SortingAlgorithm.mergeSoft(arrayInt, 0, arrayInt.length - 1);

        MyOut.println(arrayInt);
    }
}
