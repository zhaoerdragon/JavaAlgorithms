package com.xupt.willscorpio.utils;

/**
 * 创造需要的数据结构
 * 按照要求创造数组
 */
public class CreateArray {

    /**
     * 生成的随机数字的上限
     */
    public static int HighLimit = 50;

    /**
     * 生成的随机数字的下限
     */
    public static int LowLimit = -50;

    /**
     * 创建一个自定义长度1到50的整型数组
     *
     * @param quantity 数组的长 度
     * @return 返回整型数组
     */
    public static int[] createIntArray(int quantity) {
        int[] arrayint = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            arrayint[i] = (int) (Math.random() * (HighLimit - 1) + 1);
        }
        MyOut.println(arrayint);
        return arrayint;
    }

    /**
     * 生成一个自定义上限和下限的数组
     * 生成的数据范围是[low,high)
     * @param low
     * @param high
     * @param quantity
     * @return
     */
    public static int[] createIntArray(int low, int high, int quantity) {
        int[] arrayInt = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            arrayInt[i] = (int) (Math.random() * (high - low) + low);
        }
        return arrayInt;
    }

    /**
     * 创建一个从-50到50的长度自定义的整型数组
     * 但是不包括-50和50
     *
     * @param quantity 数组的长度
     * @return 整型数组
     */
    public static int[] createNegativeIntArray(int quantity) {
        int[] arrayint = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            arrayint[i] = (int) (Math.random() * (HighLimit - LowLimit) + LowLimit);
            System.out.println("第 " + (i + 1) + " 个数字是 " + arrayint[i]);
        }
        return arrayint;
    }

    /**
     * 生成一个随机n阶正数矩阵
     * @param n
     * @return
     */
    public static int[][] createMatrix(int n) {
        int[][] outMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                outMatrix[i][j] = (int) (Math.random() * (HighLimit - 1) + 1);
            }
        }
        MyOut.println("随机生成n阶矩阵如下所示:");
        MyOut.println(outMatrix);
        return outMatrix;
    }

    /**
     * 生成一个随机n阶正负矩阵
     *
     * @param n
     * @return
     */
    public static int[][] createNegativeMatrix(int n) {
        int[][] outMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                outMatrix[i][j] = (int) (Math.random() * (HighLimit - LowLimit) + LowLimit);
            }
        }
        MyOut.println("随机生成的n阶正负矩阵如下所示");
        MyOut.println(outMatrix);
        return outMatrix;
    }
}
