package com.xupt.willscorpio.algorithm;

public class FourAlgorithm {

    public static void main(String[] args) {
        int answer = mayi(1000, 0);
        System.out.println(answer);
    }

    /**
     * 向左走，向右走
     * @param A
     * @param count
     */
    private static int mayi(int A,int count) {
        if (A == 0) {
            return 0;
        }
        while (A - ++count >= 0) {
            A = A - count;
        }
        count--;
        return count + A * 2;
    }
}
