package com.xupt.willscorpio.cowguest;

public class KingAlgorithm {

    /**
     * 01背包是在M件物品取出若干件放在空间为W的背包里，每件物品的体积为W1，W2……Wn，与之相对应的价值为P1,P2……Pn。在给定容量为C的
     * 条件下，求如何选取物体使带来的价值最大化。
     *
     * @return
     */
    public void ZeroOneBag(int size, int num, int[] weight, int[] value) {
        int[][] answer = new int[num + 1][size + 1];
        for (int i = 0; i < num + 1; i++) {
            answer[i][0] = 0;
        }
        for (int j = 0; j < size + 1; j++) {
            answer[0][j] = 0;
        }
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < size+ 1; j++) {
                if (weight[i - 1] <= j) {
                    if (answer[i - 1][j] < answer[i - 1][j - weight[i - 1]] + value[i - 1]) {
                        answer[i][j] = answer[i - 1][j - weight[i - 1]] + value[i - 1];
                    } else {
                        answer[i][j] = answer[i - 1][j];
                    }
                } else {
                    answer[i][j] = answer[i - 1][j];
                }
            }
        }
        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                System.out.print(" " + answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KingAlgorithm kingAlgorithm = new KingAlgorithm();
        kingAlgorithm.ZeroOneBag(5, 3, new int[]{1, 2, 3}, new int[]{2, 2, 3});
    }
}
