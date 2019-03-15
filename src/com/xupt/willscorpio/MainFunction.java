package com.xupt.willscorpio;

public class MainFunction{

    public static void main(String[] args) {
        int answer = dp(2, 0, 0);
        System.out.println(answer);
    }


    private static int dp(int A, int num,int count) {
        while (num < A) {
            count++;
            num = num + count;
        }
        int a = -1;
        while (num > A) {
            num = num + a;
            a--;
            count++;
        }
        return count;
    }
}