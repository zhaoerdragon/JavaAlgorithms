package com.xupt.willscorpio.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class BitDance2Algorithm {

    public static void main(String[] args) {
        ArrayList<BitData> arrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        int max = 0;
        for (int i = 0; i < m; i++) {
            String string = scanner.nextLine();
            String[] tempArray = string.split(";");
            for (String tempString : tempArray) {
                String[] arryString = tempString.split(",");
                int x = Integer.parseInt(arryString[0]);
                if (x > max) {
                    max = x;
                }
                int y = Integer.parseInt(arryString[1]);
                if (y > max) {
                    max = y;
                }
                BitData bitData = new BitData(x, y);
                arrayList.add(bitData);
            }
        }

        int[] ok = new int[max + 1];
        for (BitData bitData : arrayList) {
            for (int i = bitData.x; i <= bitData.y; i++) {
                ok[i] = 1;
            }
        }

        ArrayList<BitData> answer = new ArrayList<>();
        int first = 0;
        int end = 0;
        for (int i = 0; i < ok.length; i++) {
            if (ok[i] == 1) {
                first = i;
                end = i;
                while (i + 1 < ok.length && ok[i + 1] == 1) {
                    i = i + 1;
                    end = i;
                }
                BitData bitData = new BitData(first, end);
                answer.add(bitData);
                first = 0;
                end = 0;
            }
        }

        String[] answerArray = new String[answer.size()];
        int count = 0;
        for (BitData bitData : answer) {
            String string = "" + bitData.x + "," + bitData.y;
            answerArray[count++] = string;
        }

        for (int i = 0; i < answerArray.length; i++) {
            System.out.print(answerArray[i]);
            if (i != answerArray.length - 1) {
                System.out.print(";");
            }
        }
    }

    static class BitData{
        int x;
        int y;

        public BitData(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

