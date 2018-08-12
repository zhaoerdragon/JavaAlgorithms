package com.xupt.willscorpio.utils;

import java.util.Scanner;

public class BitDance3Algorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] array = new int[n][2];

        long max = 0;
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();

            max = max + array[i][0];
            array[i][1] = scanner.nextInt();
        }

        long answer = 0;
    }
}
