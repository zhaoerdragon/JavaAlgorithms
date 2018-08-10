package com.xupt.willscorpio.swordoffer;

import com.xupt.willscorpio.cowguest.TreeNode;

import java.math.BigInteger;

public class FileOne {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent > 0) {
            double result = 1;
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
            return result;
        } else if (exponent == 0) {
            return 1;
        } else {
            int x = Math.abs(exponent);
            double result = 1;
            for (int i = 0; i < x; i++) {
                result = result * base;
            }
            return 1 / result;
        }
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        BigInteger bigInteger1 = new BigInteger("" + num1);
        BigInteger bigInteger2 = new BigInteger("" + num2);
        return bigInteger1.add(bigInteger2).intValue();
    }

    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length > 0) {
            B[0] = 1;
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            for (int j = length - 2; j >= 0; j--) {
                temp = temp * A[j + 1];
                B[j] = temp * B[j];
            }
        }
        return B;
    }

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int result = n;
        boolean bool = (result > 0 && (result = result + Sum_Solution(n - 1)) > 1);
        return result;
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return false;
    }
}
