package cowguest;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import java.util.ArrayList;

/**
 * 牛客网编程题
 */
public class BaseQuestion2 {

    /**
     * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
       给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。
       字符串的长度小于等于3000
     * @param iniString
     * @return
     */
    public boolean checkDifferent(String iniString) {
        if (iniString.length() > 256) {
            return false;
        }
        for (int i = 0; i < iniString.length(); i++) {
            for (int j = i + 1; j < iniString.length() - 1; j++) {
                if (iniString.charAt(i) == iniString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        int lie = array[0].length;
        int x = array.length - 1;
        int y = 0;
        while ((x >= 0) && y < lie) {
            if (target > array[x][y]) {
                y++;
            } else if (target < array[x][y]) {
                x--;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        String tempString = str.toString();
        return tempString.replaceAll(" ", "%20");
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return 0;
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 斐波那数列的优化版
     * @param n
     * @return
     */
    public static int FibonacciBetter(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int f = 0, g = 1;
        while (n-- > 0) {
            g = g + f;
            f = g - f;
        }
        return f;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 跳台阶问题的优化版
     * @param target
     * @return
     */
    public static int JumpFloorBetter(int target) {
        if (target <= 2) {
            return target;
        }
        int f1 = 1;
        int f2 = 0;
        int f = 0;
        for (int i = 1; i <= target; i++) {
            f = f1 + f2;
            f2 = f1;
            f1 = f;
        }
        return f;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        return 1 << (target - 1);
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 3) {
            return target;
        } else return RectCover(target - 1) + RectCover(target - 2);
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int value = 0;
        while (n != 0) {
            value++;
            n = n & (n - 1);
        }
        return value;
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {

        return 0;
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
     * 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    // TODO: 17-8-16 这个题目有难度，我还没有做出来
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int line = matrix.length;                       //行
        int column = matrix[0].length;                  //列

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                arrayList.add(matrix[i][j]);
            }
        }
        return null;
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     * @param array
     * @return
     */
    // TODO: 17-8-16 这个也没有做出来
    public static int InversePairs(int [] array) {
        int key = 0;
        int temp = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                temp = temp + 1;
                key = key + temp;
            } else if (array[i] == array[i + 1]) {
                key = key + temp;
            }else {
                for (int j = i; j < array.length; j++) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (array[j] > array[k]) {
                            key++;
                        }
                    }
                }
            }
        }
        return key%1000000007;
    }
}
