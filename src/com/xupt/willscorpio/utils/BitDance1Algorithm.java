package com.xupt.willscorpio.utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BitDance1Algorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] split = line.split(",");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        boolean stand[][] = new boolean[M][N];
        boolean flag[][] = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            line = scanner.nextLine();
            split = line.split(",");
            for (int j = 0; j < N; j++) {
                if (split[j].equals("0"))
                    stand[i][j] = false;
                else
                    stand[i][j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int count = dp(i, j, M, N, stand, flag);
                if (count > 0)
                    list.add(count);
                if (count > max)
                    max = count;
            }
        }
        System.out.println(list.size() + "," + max);
    }

    public static int dp(int x, int y, int m, int n, boolean stand[][], boolean flag[][]) {
        if (!stand[x][y] || flag[x][y])
            return 0;

        flag[x][y] = true;
        int count = 1;
        if (y > 0 && x > 0 && stand[x - 1][y - 1] && !flag[x - 1][y - 1]) {
            count += dp(x - 1, y - 1, m, n, stand, flag);
        }
        if (x > 0 && stand[x - 1][y] && !flag[x - 1][y]) {
            count += dp(x - 1, y, m, n, stand, flag);
        }
        if (y < n - 1 && x > 0 && stand[x - 1][y + 1] && !flag[x - 1][y + 1]) {
            count += dp(x - 1, y + 1, m, n, stand, flag);
        }

        if (y > 0 && stand[x][y - 1] && !flag[x][y - 1]) {
            count += dp(x, y - 1, m, n, stand, flag);
        }
        if (y < n - 1 && stand[x][y + 1] && !flag[x][y + 1]) {
            count += dp(x, y + 1, m, n, stand, flag);
        }

        if (y > 0 && x < m - 1 && stand[x + 1][y - 1] && !flag[x + 1][y - 1]) {
            count += dp(x + 1, y - 1, m, n, stand, flag);
        }
        if (x < m - 1 && stand[x + 1][y] && !flag[x + 1][y]) {
            count += dp(x + 1, y, m, n, stand, flag);
        }
        if (y < n - 1 && x < m - 1 && stand[x + 1][y + 1] && !flag[x + 1][y + 1]) {
            count += dp(x + 1, y + 1, m, n, stand, flag);
        }

        return count;
    }
}

