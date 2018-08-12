package com.xupt.willscorpio.cowguest;

public class TestAlgorithm {

    public static void main(String[] args) {
        int left = 2;
        int right = 0;
        int value = Math.abs(left - right) > 1 ? -1 : (1 + Math.max(left, right));
        System.out.println(value);
    }
}
